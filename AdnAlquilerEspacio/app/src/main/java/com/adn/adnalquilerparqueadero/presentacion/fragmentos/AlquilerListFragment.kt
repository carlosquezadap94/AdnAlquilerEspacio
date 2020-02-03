package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.adn.adnalquilerparqueadero.databinding.FragmentVehiculoBinding
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel
import com.adn.adnalquilerparqueadero.presentacion.adapters.VehiculosAlquiladosAdapter
import com.adn.adnalquilerparqueadero.utilities.InjectUtils

class AlquilerListFragment : Fragment()
{


    private val alquilerListViewModel: AlquilerListViewModel by viewModels {
        InjectUtils.provideAlquilerListViewModelFactoy()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {

        val binding = FragmentVehiculoBinding.inflate(inflater,container,false)

        var adapter = VehiculosAlquiladosAdapter()
        binding.recyclerViewVehiculo.adapter = adapter

        binding.apply {
            viewModel = alquilerListViewModel
            lifecycleOwner = viewLifecycleOwner
        }

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

    private fun subscribeUi(adapter: VehiculosAlquiladosAdapter, bindin:FragmentVehiculoBinding)
    {
        /*
         alquilerMotosListviewModel.motos.observe(viewLifecycleOwner) { result ->
            bindin.tieneParqueos = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
         */
    }



}
