package com.adn.adnalquilerparqueadero.dominio.repositorio

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IAlquilerRepositorio {

    fun crearAlquiler(alquiler: Alquiler): Boolean

    fun actualizarAlquiler(alquiler: Alquiler): LiveData<Alquiler>

    fun obtenerAlquilerPorId(id: Int): Alquiler

    fun estaAlquilado(placa: String): Boolean

    fun getAlquilerFromTipoV(tipoV: String): LiveData<List<Alquiler>>

    fun obtenerTodos(): LiveData<List<Alquiler>>

    fun obtenerCantidadXtipoVehiculo(tipoV: String): String

}