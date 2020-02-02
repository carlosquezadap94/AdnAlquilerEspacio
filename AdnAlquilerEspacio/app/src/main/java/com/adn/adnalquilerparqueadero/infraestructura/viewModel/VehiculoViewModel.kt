package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler

class VehiculoViewModel(): ViewModel()
{
    private var serviceAlquilerDominio: ServicioCrearCrearAlquiler

    init {
        serviceAlquilerDominio =  ServicioCrearCrearAlquiler()
    }

     suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
     {
         serviceAlquilerDominio.agregarAlquiler(alquilerDTO)
     }

    fun placaExiste(placa:String) = serviceAlquilerDominio.estaAlquilado(placa)

}


