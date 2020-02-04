package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler

class VehiculoViewModel(private val serviceAlquilerDominio: ServicioCrearCrearAlquiler) :
    ViewModel() {


    suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO) {
        serviceAlquilerDominio.agregarAlquiler(alquilerDTO)
    }

    suspend fun placaExiste(placa: String) = serviceAlquilerDominio.estaAlquilado(placa)

}


