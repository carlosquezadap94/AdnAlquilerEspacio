package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio


class DetalleVehiculoViewModelFactory(val repositorio: AlquilerRepositorio,val idAlquiler:Int):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>) = DetalleMotoVehiculoViewModel(repositorio,idAlquiler) as T
}