package com.adn.adnalquilerparqueadero.dominio.repositorio

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

public interface IAlquilerRepositorio {

   suspend fun crearAlquiler(alquilerDTO: AlquilerDTO)

   suspend fun obtenerAlquilerPorPlaca(placa: String):Alquiler

   suspend fun actualizarAlquiler(alquiler:Alquiler)

   suspend fun obtenerAlquilerPorId(id: Int):Alquiler

   suspend fun estaAlquilado(placa: String):Boolean

   suspend fun getAlquilerFromTipoV(tipoV: String):List<Alquiler>

   suspend fun obtenerCantidadXtipoVehiculo(tipoV: String):String

}