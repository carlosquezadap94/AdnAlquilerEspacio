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


    override fun obtenerAlquiler(id: Int) =
      iAlquilerRepositorioImpl.obtenerAlquilerPorId(id)


    override fun realizarPago(alquiler: Alquiler) {
        iAlquilerRepositorioImpl.actualizarAlquiler(alquiler)
    }

}