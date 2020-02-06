package com.adn.adnalquilerparqueadero.presentacion.fragmentos

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentDialogBinding
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler
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
private const val AUTOMOVIL = "AUTOMOVIL"
private val VEHICULOS = arrayOf("AUTOMOVIL", "MOTOCICLETA")

class CrearAlquilerDialogFragment : Fragment(), ILimpiarCampos {


    @Inject
    lateinit var serviceAlquilerDominio: ServicioCrearAlquiler

    lateinit var binding: FragmentDialogBinding

    private val vehiculoRegistroviewModel: VehiculoViewModel by viewModels {
        InjectUtils.provideAlquilerViewModelFactoy(
            serviceAlquilerDominio
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDialogBinding.inflate(inflater, container, false)

        val spinner = binding.spinnerVehiculos

        val adapter =
            ArrayAdapter<String>(activity!!, android.R.layout.simple_spinner_item, VEHICULOS)

        spinner.adapter = adapter

        binding.apply {
            motoViewModel = vehiculoRegistroviewModel
            lifecycleOwner = viewLifecycleOwner

            @SuppressLint("FragmentLiveDataObserve")
            callback = object : Callback {
                override fun click() {

                    val placa = binding.editextPlaca.text.toString()
                    var cc = binding.editextCc.text.toString()
                    val tipoVehiculo = binding.spinnerVehiculos.selectedItem.toString()


                    val condicion: Boolean

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
                                    getString(R.string.vehiculo_ya_registrado),
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
                            getString(R.string.ingresar_correctos),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        }
        return binding.root
    }

    fun agregarAlquiler(cc: String, placa: String, tipoVehiculo: String) {

        val vehiculo = Vehiculo(placa, cc.toInt(), tipoVehiculo)

        val alquiler = AlquilerDTO(vehiculo, Date())

        try {
            if (vehiculoRegistroviewModel.agregarAlquiler(alquiler)) {
                Toast.makeText(activity, resources.getString(R.string.registro_agregado), Toast.LENGTH_SHORT).show()
                limpiar()
            } else {
                Toast.makeText(activity, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }

        } catch (e: ExcepcionNegocio) {
            Toast.makeText(activity, e.mensaje, Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
        }


    }

    fun validarPlaca(placa: String): Boolean {
        return vehiculoRegistroviewModel.placaExiste(placa)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }


    override fun limpiar() {
        binding.editextCc.text = Editable.Factory.getInstance().newEditable("")
        binding.editextPlaca.text = Editable.Factory.getInstance().newEditable("")
    }


}
