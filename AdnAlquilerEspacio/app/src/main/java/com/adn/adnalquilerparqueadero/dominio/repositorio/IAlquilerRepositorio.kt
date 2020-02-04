package com.adn.adnalquilerparqueadero.dominio.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

public interface IAlquilerRepositorio {

    suspend fun crearAlquiler(alquilerDTO: AlquilerDTO)

    fun obtenerAlquilerPorPlaca(placa: String):Alquiler

    fun actualizarAlquiler(alquiler:Alquiler)

    fun obtenerAlquilerPorId(id: Int):Alquiler

    fun estaAlquilado(placa: String):Boolean

    fun getAlquilerFromTipoV(tipoV: String):LiveData<List<Alquiler>>

    fun obtenerTodos():LiveData<List<Alquiler>>

    fun obtenerCantidadXtipoVehiculo(tipoV: String):String

}