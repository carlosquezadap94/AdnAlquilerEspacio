package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentMotoBinding
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel
import com.google.samples.apps.sunflower.utilities.InjectorUtils

/**
 * A simple [Fragment] subclass.
 */
class MotoFragment : Fragment()
{

    private val viewModel: AlquilerListViewModel by viewModels {
        InjectorUtils.provideAlquilerListViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMotoBinding.inflate(inflater,container,false)




        return binding.root
    }


}
