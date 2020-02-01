package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler

class AlquilerMotosListViewModel internal constructor():ViewModel()
{

    private var serviceAlquilerDominio: ServicioAlquiler

    init {
        serviceAlquilerDominio =  ServicioAlquiler()
    }

    val motos  = serviceAlquilerDominio.obtenerVehiculosPorTipo(MOTOCICLETA)



}