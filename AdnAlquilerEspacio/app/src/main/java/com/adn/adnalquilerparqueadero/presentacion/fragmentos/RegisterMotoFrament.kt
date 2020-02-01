package com.adn.adnalquilerparqueadero.presentacion.fragmentos

import android.annotation.SuppressLint
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.adn.adnalquilerparqueadero.databinding.FragmentDialogBinding
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerMotosListViewModel
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.MotoViewModel
import com.adn.adnalquilerparqueadero.utilities.Callback
import com.adn.adnalquilerparqueadero.utilities.InjectUtils
import kotlinx.coroutines.launch
import java.util.*

const val MOTOCICLETA ="MOTOCICLETA"
class RegisterMotoFrament : DialogFragment() {


    private val motoRegistroviewModel: MotoViewModel by viewModels {
        InjectUtils.provideMotoViewModelFactoy(requireActivity())
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

        binding.apply {
            motoViewModel = motoRegistroviewModel
            lifecycleOwner = viewLifecycleOwner

            @SuppressLint("FragmentLiveDataObserve")
            callback =object :Callback{
                override fun click() {

                    var placa = binding.editextPlaca.text.toString()
                    var cc = binding.editextCc.text.toString()

                    if (!placa.isNullOrEmpty() and !cc.isNullOrEmpty())
                    {
                        var motoExiste = motoRegistroviewModel.placaExiste(placa)

                        motoExiste.observe(this@RegisterMotoFrament, androidx.lifecycle.Observer {
                            if (it)
                            {
                                Toast.makeText(activity!!.applicationContext,"ya se registro un vehiculo con esta placa",Toast.LENGTH_SHORT).show()
                            }else{
                                lifecycleScope.launch {
                                    agregarAlquiler(placa,cc)
                                }
                            }
                        })
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
        var vehiculo = Vehiculo(placa,cc.toInt(), MOTOCICLETA)

        //Todo Implementar Factory
        var alquiler = AlquilerDTO(vehiculo, Date())

        motoRegistroviewModel.agregarAlquiler(alquiler)

    }

}
