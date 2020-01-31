package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.DetalleMotoVehiculoViewModel


class DetalleVehiculoViewModelFactory(val repositorio: AlquilerRepositorio,val idAlquiler:Int):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>) = DetalleMotoVehiculoViewModel(
        repositorio,
        idAlquiler
    ) as T
}