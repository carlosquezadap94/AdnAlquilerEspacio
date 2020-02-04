package com.adn.adnalquilerparqueadero.presentacion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adn.adnalquilerparqueadero.databinding.VehiculoItemBinding
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.ControlerFragmentDirections

class VehiculosAlquiladosAdapter :
    ListAdapter<Alquiler, VehiculosAlquiladosAdapter.VehiculoViewHolder>(AlquilerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoViewHolder {
        return VehiculoViewHolder(
            VehiculoItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VehiculoViewHolder, position: Int) {
        holder.bind(getItem(position))
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

        fun bind(item: Alquiler) {
            binding.apply {
                alquiler = item
                executePendingBindings()
            }
        }


    }


}

private class AlquilerDiffCallback : DiffUtil.ItemCallback<Alquiler>() {
    override fun areItemsTheSame(oldItem: Alquiler, newItem: Alquiler): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Alquiler, newItem: Alquiler): Boolean {
        return oldItem.id == newItem.id
    }

}