package com.adn.adnalquilerparqueadero.presentacion.fragmentos

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.adn.adnalquilerparqueadero.databinding.FragmentDialogBinding
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.AUTOMOVIL
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.VehiculoViewModel
import com.adn.adnalquilerparqueadero.utilities.Callback
import com.adn.adnalquilerparqueadero.utilities.InjectUtils
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


private const val MOTOCICLETA = "MOTOCICLETA"
val VEHICULOS = arrayOf("AUTOMOVIL", "MOTOCICLETA")

class CrearAlquilerDialogFragment : DialogFragment() {


    @Inject
    lateinit var serviceAlquilerDominio: ServicioCrearCrearAlquiler

    private val vehiculoRegistroviewModel: VehiculoViewModel by viewModels {
        InjectUtils.provideAlquilerViewModelFactoy(
            activity!!.applicationContext,
            serviceAlquilerDominio
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDialogBinding.inflate(inflater, container, false)

        val spinner = binding.spinnerVehiculos

        val adapter = ArrayAdapter<String>(activity!!, R.layout.simple_spinner_item, VEHICULOS)
        spinner.adapter = adapter

        binding.apply {
            motoViewModel = vehiculoRegistroviewModel
            lifecycleOwner = viewLifecycleOwner

            @SuppressLint("FragmentLiveDataObserve")
            callback = object : Callback {
                override fun click() {

                    var placa = binding.editextPlaca.text.toString()
                    var cc = binding.editextCc.text.toString()
                    var tipoVehiculo = binding.spinnerVehiculos.selectedItem.toString()

                    var condicion: Boolean

                    if (tipoVehiculo.equals(AUTOMOVIL)) {
                        if (cc.isNullOrEmpty())
                            cc = "0"
                        condicion = !placa.isNullOrEmpty()
                    } else {
                        condicion = !placa.isNullOrEmpty() and !cc.isNullOrEmpty()
                    }

                    if (condicion) {


                        val uiScope = CoroutineScope(Dispatchers.Main)

                        uiScope.launch {
                            if (validarPlaca(placa)) {
                                Toast.makeText(
                                    activity!!.applicationContext,
                                    getString(com.adn.adnalquilerparqueadero.R.string.vehiculo_ya_registrado),
                                    Toast.LENGTH_SHORT
                                ).show()

                            } else {
                                lifecycleScope.launch {
                                    agregarAlquiler(cc, placa, tipoVehiculo)
                                }
                            }
                        }


                    } else {
                        Toast.makeText(
                            activity,
                            getString(com.adn.adnalquilerparqueadero.R.string.ingresar_correctos),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        }
        return binding.root
    }

    suspend fun agregarAlquiler(cc: String, placa: String, tipoVehiculo: String) {
        //Todo Implementar factory
        val vehiculo = Vehiculo(placa, cc.toInt(), tipoVehiculo)

        //Todo Implementar Factory
        val alquiler = AlquilerDTO(vehiculo, Date())


        try {
            vehiculoRegistroviewModel.agregarAlquiler(alquiler)
        } catch (e: ExcepcionNegocio) {
            Toast.makeText(activity, e.mensaje, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
        }


    }

    suspend fun validarPlaca(placa: String): Boolean {
        return vehiculoRegistroviewModel.placaExiste(placa)
    }


    override fun onResume() {

        val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = 600
        params.height = 600
        window.attributes = params
        super.onResume()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }


}
