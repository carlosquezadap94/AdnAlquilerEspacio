package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioListarVehiculos:ISeviceListarVehiculos{


    @Inject
    public lateinit var iAlquilerRepositorioImpl: AlquilerRepositorioImpl



    override suspend fun obtenerAlquileTipoV(tipoVehiculo: String): List<Alquiler> {
      return  iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)
    }


}