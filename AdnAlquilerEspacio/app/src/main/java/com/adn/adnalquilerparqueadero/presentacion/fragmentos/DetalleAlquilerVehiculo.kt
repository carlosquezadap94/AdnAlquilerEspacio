package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentDescripcionBinding
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.DetalleMotoVehiculoViewModel
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.VehiculoViewModel
import com.adn.adnalquilerparqueadero.utilities.InjectUtils
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class DetalleAlquilerVehiculo : Fragment() {


    private val args: DetalleAlquilerVehiculoArgs by navArgs()


    private val detalleVehiculoViewModel: DetalleMotoVehiculoViewModel by viewModels {
        InjectUtils.provideAlquilerDetalleViewModelFactoy(args.alquilerId)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


          val binding = DataBindingUtil
            .inflate<FragmentDescripcionBinding>(inflater,
                R.layout.fragment_descripcion,
                container,
                false).apply {
                viewModel = detalleVehiculoViewModel
                lifecycleOwner = viewLifecycleOwner
            }


        binding.btnPagar.setOnClickListener {
            Snackbar.make(binding.root, "se ha registrado el pago", Snackbar.LENGTH_LONG)
                .show()
        }


        return binding.root
    }

}
