package com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject

open class AlquilerRepositorioImpl @Inject constructor(alquilerDao: AlquilerDao) :
    IAlquilerRepositorio {
    var alquilerDao: AlquilerDao

    init {
        this.alquilerDao = alquilerDao
    }


    override fun crearAlquiler(alquilerDTO: AlquilerDTO) = runBlocking {
        val alquilerEntity = AlquilerEntidad(
            estaActivo = true,
            horaLlegada = Date(),
            vehiculo = alquilerDTO.vehiculo
        )


        return@runBlocking (alquilerDao.insert(alquilerEntity) != 0L)
    }

    override fun actualizarAlquiler(alquiler: Alquiler):LiveData<Alquiler> {
        alquiler.horaSalida = Date()
        alquiler.estaActivo = false
        alquilerDao.actualizarAlquiler(convertToEntity(alquiler))
        var liveData:LiveData<Alquiler> = MutableLiveData<Alquiler>(alquiler)
        return liveData
    }

    override fun obtenerAlquilerPorId(id: Int):Alquiler
    {
        return convertToDomain(alquilerDao.getAlquilerById(id))
    }

    override fun estaAlquilado(placa: String) = runBlocking {
        alquilerDao.estaAlquilado(placa)
    }

    override fun getAlquilerFromTipoV(tipoV: String) =
        Transformations.map(alquilerDao.getAlquilerFromTV(tipoV)) {
            it.map {
                it.toAlquiler()
            }
        }

    override fun obtenerTodos():LiveData<List<Alquiler>> {

        var alquileres:LiveData<List<AlquilerEntidad>> = alquilerDao.obtenerTodos()

        val alquileresToReturn =Transformations.map(alquileres) {
            it.map {
                it.toAlquiler()
            }
        }

        return alquileresToReturn
    }


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