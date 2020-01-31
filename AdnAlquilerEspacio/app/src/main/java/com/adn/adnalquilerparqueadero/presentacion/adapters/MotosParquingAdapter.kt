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
import com.adn.adnalquilerparqueadero.databinding.MotocicletaItemBinding
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.ControlerFragmentDirections

class MotosParquingAdapter:ListAdapter<AlquilerEntidad,MotosParquingAdapter.ViewHolder>(AlquilerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
         ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
             R.layout.motocicleta_item,
             parent,
             false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding:MotocicletaItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init {
            binding.setClickListener {
                binding.alquiler?.let {alquiler->
                    navigarADetalle(alquiler,it)
                }
            }
        }

        private fun navigarADetalle(alquiler: AlquilerEntidad, it: View?) {

            val direction = ControlerFragmentDirections.actionControlerFragmentToDescripcionFragment(alquiler.id!!)
            it!!.findNavController().navigate(direction)

        }

        fun bind(item: AlquilerEntidad)
        {
            binding.apply {
                alquiler = item
                executePendingBindings()
            }
        }


    }
}

private class AlquilerDiffCallback : DiffUtil.ItemCallback<AlquilerEntidad>() {
    override fun areItemsTheSame(oldItem: AlquilerEntidad, newItem: AlquilerEntidad): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: AlquilerEntidad, newItem: AlquilerEntidad): Boolean {
        return oldItem == newItem
    }

}