package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import androidx.lifecycle.MutableLiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

public interface IserviceCrearAlquiler {
    suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    suspend fun estaAlquilado(placa: String): Boolean
}