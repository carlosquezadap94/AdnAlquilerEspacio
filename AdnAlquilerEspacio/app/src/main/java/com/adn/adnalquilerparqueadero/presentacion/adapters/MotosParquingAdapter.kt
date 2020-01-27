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
import com.adn.adnalquilerparqueadero.infraestructura.entities.AlquilerEntity

//Todo verificar documentacion de ListAdapter
class MotosParquingAdapter:ListAdapter<AlquilerEntity,MotosParquingAdapter.ViewHolder>(AlquilerDiffCallback()) {

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
            binding.setClickListener { view ->
                binding.viewModel?.plantId?.let { plantId ->
                    navigateToPlant(plantId, view)
                }
            }
        }

        fun bind(plantings: AlquilerEntity) {
            with(binding) {
                //viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }


    }

}


private class AlquilerDiffCallback : DiffUtil.ItemCallback<AlquilerEntity>() {
    override fun areItemsTheSame(oldItem: AlquilerEntity, newItem: AlquilerEntity): Boolean {
        return oldItem.id == newItem.id

    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: AlquilerEntity, newItem: AlquilerEntity): Boolean {
        return oldItem == newItem
    }


}