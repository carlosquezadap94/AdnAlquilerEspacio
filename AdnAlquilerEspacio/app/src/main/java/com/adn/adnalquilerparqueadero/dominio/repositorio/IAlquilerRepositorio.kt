package com.adn.adnalquilerparqueadero.dominio.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IAlquilerRepositorio {

    fun crearAlquiler(alquilerDTO: AlquilerDTO): Long

    fun actualizarAlquiler(alquiler: Alquiler):Float

    fun obtenerAlquilerPorId(id: Int): Alquiler

    fun estaAlquilado(placa: String): Boolean

    fun getAlquilerFromTipoV(tipoV: String): LiveData<List<Alquiler>>

    fun obtenerTodos(): LiveData<List<Alquiler>>

    fun obtenerCantidadXtipoVehiculo(tipoV: String): String

}