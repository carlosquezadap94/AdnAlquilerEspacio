package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IserviceCrearAlquiler {
    suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    fun obtenerVehiculosPorTipo(tipoVehiculo: String): List<Alquiler>
    fun estaAlquilado(placa: String): Boolean
}