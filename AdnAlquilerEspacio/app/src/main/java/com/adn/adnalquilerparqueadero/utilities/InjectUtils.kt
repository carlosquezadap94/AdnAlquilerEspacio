package com.adn.adnalquilerparqueadero.utilities

import android.content.Context
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.DetalleVehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.VehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.VehiculosListViewModelFactory

object InjectUtils {


    fun provideAlquilerListViewModelFactoy(servicioListarVehiculos: ServicioListarVehiculos): VehiculosListViewModelFactory {
        return VehiculosListViewModelFactory(servicioListarVehiculos )
    }

    fun provideAlquilerViewModelFactoy(servicioCrearCrearAlquiler: ServicioCrearCrearAlquiler): VehiculoViewModelFactory {
        return VehiculoViewModelFactory(servicioCrearCrearAlquiler)
    }


    fun provideAlquilerDetalleViewModelFactoy(idAlquiler:Int,servicioDetalleVehiculo: ServicioDetalleVehiculo): DetalleVehiculoViewModelFactory {
        return DetalleVehiculoViewModelFactory(idAlquiler,servicioDetalleVehiculo)
    }


}