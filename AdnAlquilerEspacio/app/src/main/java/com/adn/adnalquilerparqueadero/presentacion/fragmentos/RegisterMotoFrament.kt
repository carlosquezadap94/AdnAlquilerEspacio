package com.adn.adnalquilerparqueadero.presentacion.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.adn.adnalquilerparqueadero.databinding.FragmentDialogBinding
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.modelo.Motocicleta
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerMotosListViewModel
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.MotoViewModel
import com.adn.adnalquilerparqueadero.utilities.Callback
import com.google.samples.apps.sunflower.utilities.InjectorUtils
import java.util.*


class RegisterMotoFrament : DialogFragment() {

    private val motoRegistroViewModel: MotoViewModel by viewModels {
        InjectorUtils.provideAlquilerListViewModelFactory(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentDialogBinding.inflate(inflater, container, false)

        view.apply {
            motoViewModel = motoRegistroViewModel
            lifecycleOwner = viewLifecycleOwner

            callback = object :Callback{
                override fun click()
                {
                    var placa = "ABC123"
                    var cc = 200

                    if (motoViewModel.placaExiste(placa).value!!)
                    {
                        var motocicleta = Motocicleta(cc,placa)

                        var alquiler =Alquiler(motocicleta,Date())
                        motoViewModel.agregarAlquiler(alquiler)
                    }
                }
            }
        }

        return view.root
    }




}
