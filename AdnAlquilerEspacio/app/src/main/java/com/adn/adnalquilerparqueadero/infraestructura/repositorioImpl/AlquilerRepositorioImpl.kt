package com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class AlquilerRepositorioImpl @Inject constructor(alquilerDao: AlquilerDao) : IAlquilerRepositorio {


    var alquilerDao: AlquilerDao


    init {
        this.alquilerDao = alquilerDao
    }


    override suspend fun crearAlquiler(alquilerDTO: AlquilerDTO) {
        val alquilerEntity = AlquilerEntidad(
            estaActivo = true,
            horaLlegada = Date(),
            vehiculo = alquilerDTO.vehiculo
        )

        return alquilerDao.insert(alquilerEntity)
    }

    override suspend fun obtenerAlquilerPorPlaca(placa: String) = runBlocking {
        val alquilerEntidad = alquilerDao.getAlquiler(placa)
        convertToDomain(alquilerEntidad)
    }


    override suspend fun actualizarAlquiler(alquiler: Alquiler) {

        alquiler.horaSalida = Date()
        alquiler.estaActivo = false
        alquilerDao.actualizarAlquiler(convertToEntity(alquiler))
    }

    override suspend fun obtenerAlquilerPorId(id: Int) = runBlocking {


        val alquilerEntidad = alquilerDao.getAlquilerById(id)
        convertToDomain(alquilerEntidad)
    }

    override suspend fun estaAlquilado(placa: String) = runBlocking {
        alquilerDao.estaAlquilado(placa)
    }

    override suspend fun getAlquilerFromTipoV(tipoV: String) = runBlocking {

        val alquileresEntidad = alquilerDao.getAlquilerFromTV(tipoV)

        val alquileres: ArrayList<Alquiler> = ArrayList()
        for (alquilerEntidad in alquileresEntidad) {
            alquileres.add(convertToDomain(alquilerEntidad))
        }
        alquileres

    }

    override suspend fun obtenerCantidadXtipoVehiculo(tipoV: String) = runBlocking {
        alquilerDao.obtenerCantidadPorTV(tipoV)
    }

    fun convertToEntity(alquiler: Alquiler): AlquilerEntidad {
        val alquilerEntity = AlquilerEntidad(
            id = alquiler.id,
            horaLlegada = Date(),
            horaSalida = Date(),
            estaActivo = true,
            vehiculo = alquiler.vehiculo
        )
        return alquilerEntity
    }

    fun convertToDomain(alquilerEntidad: AlquilerEntidad): Alquiler {

        var alquiler = Alquiler(
            id = alquilerEntidad.id,
            vehiculo = alquilerEntidad.vehiculo,
            horaSalida = alquilerEntidad.horaSalida,
            horaLlegada = alquilerEntidad.horaSalida,
            estaActivo = alquilerEntidad.estaActivo
        )
        return alquiler
    }

}