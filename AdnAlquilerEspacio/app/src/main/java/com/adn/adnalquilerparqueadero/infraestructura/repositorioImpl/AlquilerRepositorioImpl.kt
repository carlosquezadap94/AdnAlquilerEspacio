package com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl

import androidx.lifecycle.Transformations
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject

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

    override fun obtenerAlquilerPorPlaca(placa: String) = runBlocking {
        val alquilerEntidad = alquilerDao.getAlquiler(placa)
        convertToDomain(alquilerEntidad)
    }


    override fun actualizarAlquiler(alquiler: Alquiler) {
        alquiler.horaSalida = Date()
        alquiler.estaActivo = false
        alquiler.precio =alquiler.precio
        alquilerDao.actualizarAlquiler(convertToEntity(alquiler))
    }

    override fun obtenerAlquilerPorId(id: Int) = convertToDomain(alquilerDao.getAlquilerById(id))

    override fun estaAlquilado(placa: String) = runBlocking {
        alquilerDao.estaAlquilado(placa)
    }

    override fun getAlquilerFromTipoV(tipoV: String) =
        Transformations.map(alquilerDao.getAlquilerFromTV(tipoV)) {
            it.map {
                it.toAlquiler()
            }
        }

    override fun obtenerTodos() = alquilerDao.obtenerTodos()


    override fun obtenerCantidadXtipoVehiculo(tipoV: String) = runBlocking {
        alquilerDao.obtenerCantidadPorTV(tipoV)
    }

    fun convertToEntity(alquiler: Alquiler): AlquilerEntidad {
        val alquilerEntity = AlquilerEntidad(
            id = alquiler.id,
            horaLlegada = alquiler.horaLlegada,
            horaSalida = alquiler.horaSalida,
            estaActivo = alquiler.estaActivo,
            vehiculo = alquiler.vehiculo,
            precio = alquiler.precio
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