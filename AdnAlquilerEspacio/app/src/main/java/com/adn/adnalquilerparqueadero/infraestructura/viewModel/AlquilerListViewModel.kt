package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos

class AlquilerListViewModel constructor(private val servicioListarVehiculos: ServicioListarVehiculos) :
    ViewModel() {
    var alquileres = servicioListarVehiculos.obtenerTodos()

    fun obtenerPorTipoVehiculo(tipoVehiculo: String) =
        servicioListarVehiculos.obtenerAlquileTipoV(tipoVehiculo)
}