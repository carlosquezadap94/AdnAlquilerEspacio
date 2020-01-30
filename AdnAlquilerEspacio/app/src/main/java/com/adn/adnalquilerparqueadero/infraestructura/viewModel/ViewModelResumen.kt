package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio

private const val CUPOS_AUTOS = 20
private const val CUPOS_MOTOS = 10

class ViewModelResumen(alquilerRepositorio: AlquilerRepositorio)
    :ViewModel()
{
    val cant_motos = alquilerRepositorio.obtenerCantidadXtipoVehiculo("MOTOCICLETA")

    val cant_carros = alquilerRepositorio.obtenerCantidadXtipoVehiculo("AUTOMOVIL")

    val cant_motos_disponible =  cant_motos

    val cant_carros_diponible = cant_carros

}