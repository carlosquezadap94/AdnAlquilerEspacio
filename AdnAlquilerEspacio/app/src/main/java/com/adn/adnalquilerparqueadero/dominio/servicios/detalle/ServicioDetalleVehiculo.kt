package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import com.adn.adnalquilerparqueadero.dominio.inyeccion.DaggerComponenteApp
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioDetalleVehiculo:IserviceDetalle
{

    @Inject
    public lateinit var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        val component = DaggerComponenteApp.builder().build()
        component.injectDetalle(this)
    }


    override fun obtenerAlquiler(id: Int): Alquiler {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun realizarPago(alquilerId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}