package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
const val MOTOCICLETA="MOTOCICLETA"
const val AUTOMOVIL="AUTOMOVIL"
const val CANT_MOTOCICLETAS = 10
const val CANT_AUTOMOVIL = 20
class ViewModelResumen()
    :ViewModel()
{

    private var serviceAlquilerDominio: ServicioAlquiler

    init {
        serviceAlquilerDominio =  ServicioAlquiler()
    }

    /*
    val cant_motos = serviceAlquilerDominio.obtenerCantidadXtipoVehiculo(MOTOCICLETA)
    val cant_carros = alquilerRepositorioImpl.obtenerCantidadXtipoVehiculo(AUTOMOVIL)
    val cant_restantes_carros = (CANT_AUTOMOVIL - cant_motos.toInt()).toString()
    val cant_restantes_motos =  (CANT_MOTOCICLETAS - cant_motos.toInt()).toString()
     */


}