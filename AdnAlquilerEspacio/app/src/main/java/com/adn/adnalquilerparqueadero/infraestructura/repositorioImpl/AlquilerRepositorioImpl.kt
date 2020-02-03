package com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.db.AppDatabase
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class AlquilerRepositorioImpl @Inject constructor(): IAlquilerRepositorio {



    var alquilerDao: AlquilerDao

    //@Inject
     @Inject lateinit var appDatabase: AppDatabase


    init {
        this.alquilerDao = appDatabase.alquilerDao()
    }


    override suspend  fun  crearAlquiler(alquilerDTO: AlquilerDTO)
    {
        val alquilerEntity = AlquilerEntidad(estaActivo = true,
            horaLlegada = Date(),
            vehiculo = alquilerDTO.vehiculo)

        alquilerDao.insert(alquilerEntity)
    }
    override fun obtenerAlquilerPorPlaca(placa: String): Alquiler {
        val alquilerEntidad = alquilerDao.getAlquiler(placa)
        return convertToDomain(alquilerEntidad)
    }
    override fun actualizarAlquiler(alquiler: Alquiler){

        alquiler.horaSalida  =Date()
        alquiler.estaActivo=false
        alquilerDao.actualizarAlquiler(convertToEntity(alquiler))
    }
    override fun obtenerAlquilerPorId(id: Int): Alquiler {
        val alquilerEntidad = alquilerDao.getAlquilerById(id)
        return convertToDomain(alquilerEntidad)
    }
    override fun estaAlquilado(placa: String) = alquilerDao.estaAlquilado(placa)
    override fun getAlquilerFromTipoV(tipoV: String): List<Alquiler> {

        val alquileresEntidad = alquilerDao.getAlquilerFromTV(tipoV)

        val alquileres:ArrayList<Alquiler> = ArrayList()
        for (alquilerEntidad in alquileresEntidad){
            alquileres.add(convertToDomain(alquilerEntidad))
        }
        return alquileres
    }
    override fun obtenerCantidadXtipoVehiculo(tipoV: String) = runBlocking {
        alquilerDao.obtenerCantidadPorTV(tipoV)
    }
    fun convertToEntity(alquiler: Alquiler):AlquilerEntidad {
        val alquilerEntity = AlquilerEntidad(
            id = alquiler.id,
            horaLlegada = Date(),
            horaSalida = Date(),
            estaActivo = true,
            vehiculo = alquiler.vehiculo
        )
        return alquilerEntity
    }
    fun convertToDomain(alquilerEntidad: AlquilerEntidad):Alquiler {

        var alquiler =Alquiler(id = alquilerEntidad.id,
            vehiculo = alquilerEntidad.vehiculo ,
            horaSalida = alquilerEntidad.horaSalida ,
            horaLlegada = alquilerEntidad.horaSalida,
            estaActivo = alquilerEntidad.estaActivo )
        return alquiler
    }

}