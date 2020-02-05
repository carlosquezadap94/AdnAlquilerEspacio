package com.adn.adnalquilerparqueadero.presentacion.adapters

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
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.ControlerFragmentDirections

class VehiculosAlquiladosAdapter(val servicioListarVehiculos: ServicioListarVehiculos) :
    ListAdapter<AlquilerEntidad, RecyclerView.ViewHolder>(AlquilerDiffCallback()) {


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

        private fun navigarADetalle(alquiler: AlquilerEntidad, it: View?) {
            val direction =
                ControlerFragmentDirections.actionControlerFragmentToDescripcionFragment(alquiler.id!!)
            it!!.findNavController().navigate(direction)
        }

        fun bind(item: AlquilerEntidad, servicioListarVehiculos: ServicioListarVehiculos) {


            with(binding) {
                binding.alquiler = item
                viewModel = AlquilerListViewModel(servicioListarVehiculos)
                executePendingBindings()
            }

        }


    }


}

private class AlquilerDiffCallback : DiffUtil.ItemCallback<AlquilerEntidad>() {
    override fun areItemsTheSame(oldItem: AlquilerEntidad, newItem: AlquilerEntidad): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AlquilerEntidad, newItem: AlquilerEntidad): Boolean {
        return oldItem == newItem
    }

}