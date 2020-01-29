package com.adn.adnalquilerparqueadero.infraestructura.repositorio

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

class AlquilerRepositorio private constructor(private val alquilerDao: AlquilerDao) {


    suspend fun createAlquiler(alquiler: Alquiler)
    {
        val alquilerEntity = AlquilerEntidad()
        alquilerDao.insert(alquilerEntity)
    }

    //Todo  Repasar concepto suspend function
    //suspend function is a function that could be started, paused and resume
    /*
    suspend fun getAlquiler(placa: String):LiveData<AlquilerEntidad>
    {
        return alquilerDao.getAlquiler(placa)
    }
     */



    suspend fun getAlquilerFromTipoV(tipoV: String):LiveData<List<AlquilerEntidad>>
    {
        return alquilerDao.getAlquilerFromTV(tipoV)
    }



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