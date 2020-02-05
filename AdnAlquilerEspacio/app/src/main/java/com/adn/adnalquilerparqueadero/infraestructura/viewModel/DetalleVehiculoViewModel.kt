package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo

class DetalleMotoVehiculoViewModel(
    private val servicioDetalleVehiculo: ServicioDetalleVehiculo,
    private val idAlquiler: Int
) : ViewModel() {

    val pago: MutableLiveData<Boolean> = MutableLiveData(false)
    var alquiler = MutableLiveData<Alquiler>(servicioDetalleVehiculo.obtenerAlquiler(idAlquiler))

    suspend fun realizarPago() {
        viewModelScope.let {
            alquiler.value!!.precio = servicioDetalleVehiculo.realizarPago(alquiler.value!!)
        }

    }


}