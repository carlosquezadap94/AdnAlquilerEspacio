package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.MOTOCICLETA
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos

class AlquilerListViewModel internal constructor():ViewModel()
{
    private var servicioListarVehiculos: ServicioListarVehiculos

    init {
        servicioListarVehiculos =  ServicioListarVehiculos()
    }

    val alquilere:List<Alquiler>  = servicioListarVehiculos.obtenerAlquileTipoV(MOTOCICLETA)

}