package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquilerDominio

class AlquilerMotosListViewModel internal constructor():ViewModel()
{

    private var serviceAlquilerDominio: ServicioAlquilerDominio

    init {
        serviceAlquilerDominio =  ServicioAlquilerDominio()
    }

    val motos  = serviceAlquilerDominio.obtenerVehiculosPorTipo(MOTOCICLETA)



}