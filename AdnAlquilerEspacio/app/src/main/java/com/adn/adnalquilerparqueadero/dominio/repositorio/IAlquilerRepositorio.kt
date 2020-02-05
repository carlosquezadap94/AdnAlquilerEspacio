package com.adn.adnalquilerparqueadero.dominio.repositorio

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

interface IAlquilerRepositorio {

    fun crearAlquiler(alquilerDTO: AlquilerDTO): Long

    fun obtenerAlquilerPorPlaca(placa: String): Alquiler

    fun actualizarAlquiler(alquiler: Alquiler)

    fun obtenerAlquilerPorId(id: Int): Alquiler

    fun estaAlquilado(placa: String): Boolean

    fun getAlquilerFromTipoV(tipoV: String): LiveData<List<Alquiler>>

    fun obtenerTodos(): LiveData<List<AlquilerEntidad>>

    fun obtenerCantidadXtipoVehiculo(tipoV: String): String

}