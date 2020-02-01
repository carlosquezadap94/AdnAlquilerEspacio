package com.adn.adnalquilerparqueadero.dominio.servicios

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.inyeccion.DaggerComponenteApp
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioAlquiler :IserviceAlquiler {

     @Inject public lateinit var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
       val component = DaggerComponenteApp.builder().build()
        component.inject(this)
    }

    override suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    {
        iAlquilerRepositorioImpl.createAlquiler(alquilerDTO)
    }

    override fun obtenerVehiculosPorTipo(tipoVehiculo: String):  List<Alquiler>{
       return iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)
    }


    override fun estaAlquilado(placa:String): LiveData<Boolean>
    {
        return iAlquilerRepositorioImpl.estaAlquilado(placa)
    }



}