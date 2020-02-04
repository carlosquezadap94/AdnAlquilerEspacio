package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

public interface IserviceCrearAlquiler {
    suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    suspend fun obtenerVehiculosPorTipo(tipoVehiculo: String): List<Alquiler>
    suspend fun estaAlquilado(placa: String): Boolean
}