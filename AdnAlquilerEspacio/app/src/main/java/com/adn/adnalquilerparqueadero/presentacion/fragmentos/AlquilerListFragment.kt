package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.adn.adnalquilerparqueadero.databinding.FragmentVehiculoBinding
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel
import com.adn.adnalquilerparqueadero.presentacion.adapters.VehiculosAlquiladosAdapter
import com.adn.adnalquilerparqueadero.utilities.InjectUtils
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class AlquilerListFragment : Fragment() {

    private lateinit var binding: FragmentVehiculoBinding
    lateinit var adapter: VehiculosAlquiladosAdapter

    @Inject
    lateinit var servicioListarVehiculos: ServicioListarVehiculos

    private val vehiculoListviewModel: AlquilerListViewModel by viewModels {
        InjectUtils.provideAlquilerListViewModelFactoy(
            servicioListarVehiculos
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVehiculoBinding.inflate(inflater, container, false)

        adapter = VehiculosAlquiladosAdapter(servicioListarVehiculos)

        binding.recyclerViewVehiculo.adapter = adapter

        subscribeUi(adapter, binding)

        binding.addFragment.setOnClickListener {
            abrirDialog()
        }

        return binding.root
    }

    fun abrirDialog() {
        val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        val prev = activity!!.supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            fragmentTransaction.remove(prev)
        }
        fragmentTransaction.addToBackStack(null)
        val dialogFragment = CrearAlquilerDialogFragment() //here MyDialog is my custom dialog
        dialogFragment.show(fragmentTransaction, "dialog")
    }

    private fun subscribeUi(adapter: VehiculosAlquiladosAdapter, bindin: FragmentVehiculoBinding) {
        val obter = vehiculoListviewModel.obtenerTodos()
        obter.observe(viewLifecycleOwner, Observer { result ->
            bindin.tieneParqueos = !result.isNullOrEmpty()
            adapter.submitList(result)
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }


}
