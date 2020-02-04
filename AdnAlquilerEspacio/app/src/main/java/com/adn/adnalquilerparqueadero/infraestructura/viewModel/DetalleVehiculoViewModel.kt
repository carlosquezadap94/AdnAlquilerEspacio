package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo

class DetalleMotoVehiculoViewModel(
    private val servicioDetalleVehiculo: ServicioDetalleVehiculo,
    private val idAlquiler: Int
) : ViewModel() {

    val pago :MutableLiveData<Boolean> = MutableLiveData(false)
    var alquiler = servicioDetalleVehiculo.obtenerAlquiler(idAlquiler)

    suspend fun realizarPago() {
        servicioDetalleVehiculo.realizarPago(alquiler)
        pago.value  = true
    }


}