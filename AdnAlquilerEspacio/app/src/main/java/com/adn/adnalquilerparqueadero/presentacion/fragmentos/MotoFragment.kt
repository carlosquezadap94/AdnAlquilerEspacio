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
import com.adn.adnalquilerparqueadero.utilities.Callback
import com.google.samples.apps.sunflower.utilities.InjectorUtils

class MotoFragment : Fragment()
{

    private val alquilerMotosListviewModel: AlquilerMotosListViewModel by viewModels {
        InjectorUtils.provideAlquilerListViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMotoBinding.inflate(inflater,container,false).apply {
            viewModel = alquilerMotosListviewModel
            lifecycleOwner = viewLifecycleOwner

            callback = object :Callback{
                override fun click() {
                    abrirDialog()
                }

            }
        }

        var adapter = MotosParquingAdapter()

        binding.recyclerViewMotos.adapter = adapter

        binding.addFragment.setOnClickListener {
            abrirDialog()
        }

        subscribeUi(adapter,binding)
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

    private fun subscribeUi(adapter: MotosParquingAdapter, binding: FragmentMotoBinding)
    {
        alquilerMotosListviewModel.motos.observe(viewLifecycleOwner) { result ->
            binding.existeMoto = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }



}
