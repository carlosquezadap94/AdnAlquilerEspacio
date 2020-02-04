package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalleMotoVehiculoViewModel ( private val idAlquiler:Int):ViewModel()
{


    private var serviceDetalle: ServicioDetalleVehiculo

    init {
        serviceDetalle =  ServicioDetalleVehiculo()
    }


  //  var alquiler = serviceDetalle.obtenerAlquiler(idAlquiler)

    /*
       fun realizarPago()
    {
        serviceDetalle.realizarPago(alquiler)
    }
     */




}