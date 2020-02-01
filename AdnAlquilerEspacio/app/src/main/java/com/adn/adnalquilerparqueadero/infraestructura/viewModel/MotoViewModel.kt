package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquilerDominio

class MotoViewModel(): ViewModel()
{
    private var serviceAlquilerDominio:ServicioAlquilerDominio

    init {
        serviceAlquilerDominio =  ServicioAlquilerDominio()
    }



     suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
     {
         serviceAlquilerDominio.agregarAlquiler(alquilerDTO)
     }

    fun placaExiste(placa:String): LiveData<Boolean> = serviceAlquilerDominio.estaAlquilado(placa)


}


