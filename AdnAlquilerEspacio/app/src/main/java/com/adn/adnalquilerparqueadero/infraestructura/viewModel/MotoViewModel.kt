package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler

class MotoViewModel(): ViewModel()
{
    private var serviceAlquilerDominio: ServicioAlquiler

    init {
        serviceAlquilerDominio =  ServicioAlquiler()
    }

     suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
     {
         serviceAlquilerDominio.agregarAlquiler(alquilerDTO)
     }

    fun placaExiste(placa:String): LiveData<Boolean> = serviceAlquilerDominio.estaAlquilado(placa)


}


