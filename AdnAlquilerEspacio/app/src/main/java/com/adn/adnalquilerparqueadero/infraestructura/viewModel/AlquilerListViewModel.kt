package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

class AlquilerListViewModel constructor(private val servicioListarVehiculos: ServicioListarVehiculos) :
    ViewModel()
{


    fun obtenerPorTipoVehiculo(tipoVehiculo: String) =
        servicioListarVehiculos.obtenerAlquileTipoV(tipoVehiculo)

    fun obtenerTodos():LiveData<List<Alquiler>>{
        val alquileres:LiveData<List<Alquiler>> = servicioListarVehiculos.obtenerTodos()
        return alquileres
    }
}