package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject

class ServicioListarVehiculos @Inject constructor(val iAlquilerRepositorioImpl: IAlquilerRepositorio) :
    ISeviceListarVehiculos {

    override fun obtenerTodos(): LiveData<List<Alquiler>> = iAlquilerRepositorioImpl.obtenerTodos()

    override fun obtenerAlquileTipoV(tipoVehiculo: String) =
        iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)
}