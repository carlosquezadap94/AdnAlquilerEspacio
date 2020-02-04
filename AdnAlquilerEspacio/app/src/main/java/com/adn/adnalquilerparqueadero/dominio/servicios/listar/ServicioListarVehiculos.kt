package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioListarVehiculos @Inject constructor(alquilerRepo: AlquilerRepositorioImpl) :
    ISeviceListarVehiculos {

    var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        this.iAlquilerRepositorioImpl = alquilerRepo
    }

    override fun obtenerTodos() = iAlquilerRepositorioImpl.obtenerTodos()

    override fun obtenerAlquileTipoV(tipoVehiculo: String) =
        iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)


}