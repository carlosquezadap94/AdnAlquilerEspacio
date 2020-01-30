package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentMotoBinding
import com.adn.adnalquilerparqueadero.databinding.FragmentResumenBinding
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerMotosListViewModel
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.ResumentViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.ViewModelResumen
import com.adn.adnalquilerparqueadero.presentacion.adapters.MotosParquingAdapter
import com.google.samples.apps.sunflower.utilities.InjectorUtils

/**
 * A simple [Fragment] subclass.
 */
class ResumenFragment : Fragment()
{
    private val resumentViewModel: ViewModelResumen by viewModels {
        InjectorUtils.provideResumenAlquilerViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val binding = DataBindingUtil
            .inflate<FragmentResumenBinding>(inflater,
                R.layout.fragment_resumen,
                container,
                false).apply {
                viewModel = resumentViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }
}
