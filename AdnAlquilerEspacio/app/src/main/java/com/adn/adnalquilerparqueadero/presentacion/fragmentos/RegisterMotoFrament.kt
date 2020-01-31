package com.adn.adnalquilerparqueadero.presentacion.fragmentos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.adn.adnalquilerparqueadero.databinding.FragmentDialogBinding
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.modelo.Motocicleta
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.MotoViewModel
import com.adn.adnalquilerparqueadero.utilities.Callback
import com.google.android.material.snackbar.Snackbar
import com.google.samples.apps.sunflower.utilities.InjectorUtils
import io.reactivex.Observable
import java.util.*


class RegisterMotoFrament : DialogFragment() {

    private val motoRegistroViewModel: MotoViewModel by viewModels {
        InjectorUtils.provideMotoAlquilerViewModelFactory(requireContext())
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
            motoViewModel = motoRegistroViewModel
            lifecycleOwner = viewLifecycleOwner

            callback = object :Callback{
                @SuppressLint("FragmentLiveDataObserve")
                override fun click()
                {
                     var placa = binding.editextPlaca.text.toString()
                     var cc = binding.editextCc.text.toString()

                    if (!placa.isNullOrEmpty() and !cc.isNullOrEmpty())
                    {
                        motoRegistroViewModel.placaExiste(placa).observe(this@RegisterMotoFrament,
                            androidx.lifecycle.Observer {
                                if (it){
                                    Toast.makeText(activity!!.applicationContext,"ya se registro un vehiculo con esta placa",Toast.LENGTH_SHORT).show()
                                }else{

                                        var motocicleta = Motocicleta(cc.toInt(),placa)
                                        var alquiler =Alquiler(motocicleta,Date())

                                        motoRegistroViewModel.agregarAlquiler(alquiler)

                                        Snackbar.make(root, "se ha registrado el vehiculo", Snackbar.LENGTH_LONG)
                                            .show()
                                }
                            })

                    }else
                    {
                        Toast.makeText(activity,"Deben ingresar todos los datos",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        return binding.root
    }

}
