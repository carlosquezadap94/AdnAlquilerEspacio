package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.adn.adnalquilerparqueadero.databinding.FragmentMotoBinding
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.MotosListViewModel
import com.google.samples.apps.sunflower.utilities.InjectorUtils

class MotoFragment : Fragment()
{

    private val motosListviewModel: MotosListViewModel by viewModels {
        InjectorUtils.provideAlquilerListViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMotoBinding.inflate(inflater,container,false).apply {
            viewModel = motosListviewModel
            lifecycleOwner = viewLifecycleOwner


        }

        binding.addFragment.setOnClickListener {
            abrirDialog()
        }




        return binding.root
    }


    fun abrirDialog () {

        val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        val prev = activity!!.supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            fragmentTransaction.remove(prev)
        }
        fragmentTransaction.addToBackStack(null)
        val dialogFragment = DialogFragmento() //here MyDialog is my custom dialog
        dialogFragment.show(fragmentTransaction, "dialog")
    }


}
