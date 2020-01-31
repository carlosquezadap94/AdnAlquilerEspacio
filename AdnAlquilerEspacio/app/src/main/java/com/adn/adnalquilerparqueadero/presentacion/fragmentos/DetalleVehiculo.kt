package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentDescripcionBinding
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.DetalleMotoVehiculoViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.samples.apps.sunflower.utilities.InjectorUtils
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class DetalleVehiculo : Fragment() {


    private val args: DetalleVehiculoArgs by navArgs()


    private val descripcionViewmodel: DetalleMotoVehiculoViewModel by viewModels {
        InjectorUtils.provideDetalleAlquilerViewModelFactory(requireContext(), args.alquilerId)
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
                viewModel = descripcionViewmodel
                lifecycleOwner = viewLifecycleOwner
            }


        binding.btnPagar.setOnClickListener {
           descripcionViewmodel.alquiler.observe(viewLifecycleOwner, Observer {
               try {
                   descripcionViewmodel.pagarAlquiler(alquiler = it!!)
               }catch (e:Exception){
                   e.printStackTrace()
               }
           })

            Snackbar.make(binding.root, "se ha registrado el pago", Snackbar.LENGTH_LONG)
                .show()
        }


        return binding.root
    }

}
