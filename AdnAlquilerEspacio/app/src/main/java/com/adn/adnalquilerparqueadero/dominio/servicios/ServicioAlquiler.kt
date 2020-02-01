package com.adn.adnalquilerparqueadero.dominio.servicios

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.inyeccion.DaggerComponenteApp
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioAlquiler :IserviceAlquiler {

     @Inject public lateinit var repositorioAlquilerImpl:AlquilerRepositorioImpl

    init {
        DaggerComponenteApp.create().inject(this)
    }

    override suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    {
        repositorioAlquilerImpl.createAlquiler(alquilerDTO)
    }

    override fun obtenerVehiculosPorTipo(tipoVehiculo: String):  List<Alquiler>{
       return repositorioAlquilerImpl.getAlquilerFromTipoV(tipoVehiculo)
    }


    override fun estaAlquilado(placa:String): LiveData<Boolean>
    {
        return repositorioAlquilerImpl.estaAlquilado(placa)
    }



}