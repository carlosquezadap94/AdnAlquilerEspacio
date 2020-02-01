package com.adn.adnalquilerparqueadero.dominio.repositorio

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

interface IAlquilerRepositorio {

   suspend fun createAlquiler(alquilerDTO: AlquilerDTO)

   fun obtenerAlquilerPorPlaca(placa: String):Alquiler

   fun actualizarAlquiler(alquiler:Alquiler)

   fun obtenerAlquilerPorId(id: Int):Alquiler

   fun estaAlquilado(placa: String):LiveData<Boolean>

   fun getAlquilerFromTipoV(tipoV: String):List<Alquiler>

   fun obtenerCantidadXtipoVehiculo(tipoV: String):String

}