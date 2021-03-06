package com.adn.adnalquilerparqueadero.presentacion.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.VehiculoItemBinding
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.ControlerFragmentDirections

class VehiculosAlquiladosAdapter(val servicioListarVehiculos: ServicioListarVehiculos) :
    ListAdapter<Alquiler, RecyclerView.ViewHolder>(AlquilerDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoViewHolder {
        return VehiculoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.vehiculo_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VehiculoViewHolder).bind(getItem(position), servicioListarVehiculos)
    }

    class VehiculoViewHolder(private val binding: VehiculoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.alquiler?.let { alquiler ->
                    navigarADetalle(alquiler, it)
                }
            }
        }

        private fun navigarADetalle(alquiler: Alquiler, it: View?) {
            val direction =
                ControlerFragmentDirections.actionControlerFragmentToDescripcionFragment(alquiler.id!!)
            it!!.findNavController().navigate(direction)
        }

        fun bind(item: Alquiler, servicioListarVehiculos: ServicioListarVehiculos) {
            with(binding) {
                binding.alquiler = item
                viewModel = AlquilerListViewModel(servicioListarVehiculos)
                executePendingBindings()
            }
        }
    }
}

private class AlquilerDiffCallback : DiffUtil.ItemCallback<Alquiler>() {
    override fun areItemsTheSame(oldItem: Alquiler, newItem: Alquiler): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Alquiler, newItem: Alquiler): Boolean {
        return oldItem == newItem
    }

}