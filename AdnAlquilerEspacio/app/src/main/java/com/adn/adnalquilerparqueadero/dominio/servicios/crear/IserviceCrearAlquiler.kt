package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

public interface IserviceCrearAlquiler {
    suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    fun obtenerVehiculosPorTipo(tipoVehiculo: String): List<Alquiler>
    fun estaAlquilado(placa: String): Boolean
}