package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.DetalleMotoVehiculoViewModel


class DetalleVehiculoViewModelFactory(val repositorioImpl: AlquilerRepositorioImpl, val idAlquiler:Int):ViewModelProvider.NewInstanceFactory(){


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) = DetalleMotoVehiculoViewModel(
        repositorioImpl,
        idAlquiler
    ) as T
}