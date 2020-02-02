package com.adn.adnalquilerparqueadero.utilities

import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.DetalleVehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.VehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.VehiculosListViewModelFactory

object InjectUtils {


    fun provideAlquilerListViewModelFactoy(): VehiculosListViewModelFactory {
        return VehiculosListViewModelFactory()
    }

    fun provideAlquilerViewModelFactoy(): VehiculoViewModelFactory {
        return VehiculoViewModelFactory()
    }


    fun provideAlquilerDetalleViewModelFactoy(idAlquiler:Int): DetalleVehiculoViewModelFactory {
        return DetalleVehiculoViewModelFactory(idAlquiler)
    }


}