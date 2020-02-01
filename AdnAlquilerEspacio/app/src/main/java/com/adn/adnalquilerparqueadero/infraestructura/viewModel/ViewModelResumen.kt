package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl


const val MOTOCICLETA="MOTOCICLETA"
const val AUTOMOVIL="AUTOMOVIL"
class ViewModelResumen(alquilerRepositorioImpl: AlquilerRepositorioImpl)
    :ViewModel()
{
    val cant_motos = alquilerRepositorioImpl.obtenerCantidadXtipoVehiculo(MOTOCICLETA)
    val cant_carros = alquilerRepositorioImpl.obtenerCantidadXtipoVehiculo(AUTOMOVIL)
}