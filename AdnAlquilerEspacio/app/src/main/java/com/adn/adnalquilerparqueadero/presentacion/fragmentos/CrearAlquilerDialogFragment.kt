package com.adn.adnalquilerparqueadero.presentacion.fragmentos

import android.R
import android.annotation.SuppressLint
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
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.VehiculoViewModel
import com.adn.adnalquilerparqueadero.utilities.Callback
import com.adn.adnalquilerparqueadero.utilities.InjectUtils
import kotlinx.coroutines.launch
import java.util.*


private const val MOTOCICLETA ="MOTOCICLETA"
class RegisterMotoFrament : DialogFragment() {


    private val vehiculoRegistroviewModel: VehiculoViewModel by viewModels {
        InjectUtils.provideAlquilerViewModelFactoy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDialogBinding.inflate(inflater, container, false)

        val auto = arrayOf("AUTOMOVIL","MOTOCICLETA")

        val spinner = binding.spinnerVehiculos

        val adapter = ArrayAdapter<String>(activity!!, R.layout.simple_spinner_item, auto)
        spinner.adapter = adapter
        
        

        binding.apply {
            motoViewModel = vehiculoRegistroviewModel
            lifecycleOwner = viewLifecycleOwner

            @SuppressLint("FragmentLiveDataObserve")
            callback =object :Callback{
                override fun click() {

                    var placa = binding.editextPlaca.text.toString()
                    var cc = binding.editextCc.text.toString()
                    var tipoVehiculo = binding.spinnerVehiculos.selectedItem.toString()

                    var condicion: Boolean

                    if (tipoVehiculo.equals(AUTOMOVIL))
                    {
                        condicion = !placa.isNullOrEmpty()
                    }else
                    {
                        condicion = !placa.isNullOrEmpty() and !cc.isNullOrEmpty()
                    }

                    if (condicion)
                    {
                        try {
                            if (vehiculoRegistroviewModel.placaExiste(placa))
                            {
                                Toast.makeText(activity!!.applicationContext,"Ya se registro un vehiculo con esta placa",Toast.LENGTH_SHORT).show()

                            }else{
                                lifecycleScope.launch {
                                    agregarAlquiler(placa,cc)
                                }
                            }
                        }catch (e:ExcepcionNegocio)
                        {
                            Toast.makeText(activity,e.message,Toast.LENGTH_SHORT).show()
                        }catch (e:Exception)
                        {

                            Toast.makeText(activity,e.message,Toast.LENGTH_SHORT).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(activity,"Deben ingresar todos los datos",Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
        return binding.root
    }

    suspend fun agregarAlquiler(cc:String, placa:String)
    {
           //Todo Implementar factory
        val vehiculo = Vehiculo(placa,cc.toInt(), MOTOCICLETA)

        //Todo Implementar Factory
        val alquiler = AlquilerDTO(vehiculo, Date())

        vehiculoRegistroviewModel.agregarAlquiler(alquiler)

    }


    override fun onResume() {

        val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = 600
        params.height = 600
        window.attributes = params
        super.onResume()
    }


}
