package com.adn.adnalquilerparqueadero.dominio.repositorio

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

public interface IAlquilerRepositorio {

   suspend fun crearAlquiler(alquilerDTO: AlquilerDTO)

   fun obtenerAlquilerPorPlaca(placa: String):Alquiler

   fun actualizarAlquiler(alquiler:Alquiler)

   fun obtenerAlquilerPorId(id: Int):Alquiler

   fun estaAlquilado(placa: String):Boolean

   fun getAlquilerFromTipoV(tipoV: String):List<Alquiler>

   fun obtenerCantidadXtipoVehiculo(tipoV: String):String

}