package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import com.adn.adnalquilerparqueadero.dominio.inyeccion.DaggerComponenteApp
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioListarVehiculos:ISeviceListarVehiculos {


    @Inject
    public lateinit var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        val component = DaggerComponenteApp.builder().build()
        component.injectList(this)
    }

    override fun obtenerAlquileTipoV(tipoVehiculo: String): List<Alquiler> {
      return  iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)
    }
}