package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler

class VehiculoViewModel(private val serviceAlquilerDominio: ServicioCrearAlquiler) :
    ViewModel() {

    fun agregarAlquiler(alquilerDTO: AlquilerDTO):Boolean {
      return  serviceAlquilerDominio.agregarAlquiler(alquilerDTO)
    }

    fun placaExiste(placa: String): Boolean {
        return serviceAlquilerDominio.estaAlquilado(placa)
    }

}


