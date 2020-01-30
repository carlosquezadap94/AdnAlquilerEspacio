package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.adn.adnalquilerparqueadero.databinding.FragmentMotoBinding
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerMotosListViewModel
import com.adn.adnalquilerparqueadero.presentacion.adapters.MotosParquingAdapter
import com.google.samples.apps.sunflower.utilities.InjectorUtils

class MotoListFragment : Fragment()
{

    private val alquilerMotosListviewModel: AlquilerMotosListViewModel by viewModels {
        InjectorUtils.provideAlquilerListViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        val binding = FragmentMotoBinding.inflate(inflater,container,false)
        //Todo Validar
        context ?: return binding.root

        var adapter = MotosParquingAdapter()
        binding.recyclerViewMotos.adapter = adapter

        subscribeUi(adapter,binding)


        binding.addFragment.setOnClickListener {
            abrirDialog()
        }

        return binding.root
    }


    fun abrirDialog ()
    {
        val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        val prev = activity!!.supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            fragmentTransaction.remove(prev)
        }
        fragmentTransaction.addToBackStack(null)
        val dialogFragment = RegisterMotoFrament() //here MyDialog is my custom dialog
        dialogFragment.show(fragmentTransaction, "dialog")
    }

    private fun subscribeUi(adapter: MotosParquingAdapter,bindin:FragmentMotoBinding)
    {
        alquilerMotosListviewModel.motos.observe(viewLifecycleOwner) { result ->
            bindin.tieneParqueos = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }



}
