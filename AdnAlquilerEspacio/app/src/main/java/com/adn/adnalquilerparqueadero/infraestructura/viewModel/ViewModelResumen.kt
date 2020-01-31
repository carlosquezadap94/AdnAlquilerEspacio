package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio


const val MOTOCICLETA="MOTOCICLETA"
const val AUTOMOVIL="AUTOMOVIL"
class ViewModelResumen(alquilerRepositorio: AlquilerRepositorio)
    :ViewModel()
{
    val cant_motos = alquilerRepositorio.obtenerCantidadXtipoVehiculo(MOTOCICLETA)
    val cant_carros = alquilerRepositorio.obtenerCantidadXtipoVehiculo(AUTOMOVIL)
}