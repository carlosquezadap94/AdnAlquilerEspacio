package com.adn.adnalquilerparqueadero.infraestructura.repositorio

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

class AlquilerRepositorio (private val alquilerDao: AlquilerDao) {


    suspend fun createAlquiler(alquiler: Alquiler)
    {
        val alquilerEntity = AlquilerEntidad()
        alquilerDao.insert(alquilerEntity)
    }
    fun obtenerAlquilerPorPlaca(placa: String)=alquilerDao.getAlquiler(placa)
    fun estaAlquilado(placa: String)=alquilerDao.estaAlquilado(placa)
    fun getAlquilerFromTipoV(tipoV: String)=alquilerDao.getAlquilerFromTV(tipoV)


    companion object
    {
        //Todo repasar concepto
        //Volatile fields provide memory visibility and guarantee that the value that is being read
        @Volatile private var instance: AlquilerRepositorio? = null

        fun getInstance(alquiler: AlquilerDao) =
            instance ?: synchronized(this) {
                instance ?: AlquilerRepositorio(alquiler).also { instance = it }
            }
    }

}