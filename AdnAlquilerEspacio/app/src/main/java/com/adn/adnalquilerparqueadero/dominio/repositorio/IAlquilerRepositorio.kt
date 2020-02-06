package com.adn.adnalquilerparqueadero.dominio.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IAlquilerRepositorio {

    fun crearAlquiler(alquilerDTO: AlquilerDTO): Boolean

    fun actualizarAlquiler(alquiler: Alquiler):LiveData<Alquiler>

    fun obtenerAlquilerPorId(id: Int): Alquiler

    fun estaAlquilado(placa: String): Boolean

    fun getAlquilerFromTipoV(tipoV: String): LiveData<List<Alquiler>>

    fun obtenerTodos(): LiveData<List<Alquiler>>

    fun obtenerCantidadXtipoVehiculo(tipoV: String): String

}