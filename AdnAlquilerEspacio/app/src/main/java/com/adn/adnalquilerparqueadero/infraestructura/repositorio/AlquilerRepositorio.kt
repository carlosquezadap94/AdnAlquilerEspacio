package com.adn.adnalquilerparqueadero.infraestructura.repositorio

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import java.util.*

class AlquilerRepositorio (private val alquilerDao: AlquilerDao) {

    suspend fun createAlquiler(alquiler: Alquiler) {
        val alquilerEntity = AlquilerEntidad(estaActivo = true,horaLlegada = Date(),tipoEspacioVehiculo = alquiler.vehiculo!!.tipoVehiculo(),vehiculo = AlquilerEntidad.Vehiculo(alquiler.vehiculo!!.placa))
        alquilerDao.insert(alquilerEntity)
    }

    fun obtenerAlquilerPorPlaca(placa: String)=alquilerDao.getAlquiler(placa)

    fun actualizarAlquiler(alquiler: AlquilerEntidad) {
        alquiler.apply {
            horaSalida = Date()
            estaActivo=false
        }
        alquilerDao.actualizarAlquiler(alquiler)
    }

    fun obtenerAlquilerPorId(id: Int)=alquilerDao.getAlquilerById(id)

    fun estaAlquilado(placa: String)=alquilerDao.estaAlquilado(placa)

    fun getAlquilerFromTipoV(tipoV: String)=alquilerDao.getAlquilerFromTV(tipoV)

    fun obtenerCantidadXtipoVehiculo(tipoV: String) = alquilerDao.obtenerCantidadPorTV(tipoV)

    companion object
    {  @Volatile private var instance: AlquilerRepositorio? = null

        fun getInstance(alquiler: AlquilerDao) =
            instance ?: synchronized(this) {
                instance ?: AlquilerRepositorio(alquiler).also { instance = it }
            }
    }
}