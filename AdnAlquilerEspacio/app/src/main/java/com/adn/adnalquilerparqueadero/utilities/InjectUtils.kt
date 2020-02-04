package com.adn.adnalquilerparqueadero.utilities

import android.content.Context
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.DetalleVehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.VehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.VehiculosListViewModelFactory

object InjectUtils {


    fun provideAlquilerListViewModelFactoy(): VehiculosListViewModelFactory {
        return VehiculosListViewModelFactory()
    }

    fun provideAlquilerViewModelFactoy(context: Context,serviceAlquilerDominio: ServicioCrearCrearAlquiler): VehiculoViewModelFactory {
        return VehiculoViewModelFactory(context,serviceAlquilerDominio)
    }


    fun provideAlquilerDetalleViewModelFactoy(idAlquiler:Int): DetalleVehiculoViewModelFactory {
        return DetalleVehiculoViewModelFactory(idAlquiler)
    }


}