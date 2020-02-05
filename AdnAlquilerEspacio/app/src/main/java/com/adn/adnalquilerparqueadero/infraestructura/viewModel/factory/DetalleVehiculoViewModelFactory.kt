package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.DetalleMotoVehiculoViewModel


class DetalleVehiculoViewModelFactory(
    val idAlquiler: Int,
    private val servicioDetalleVehiculo: ServicioDetalleVehiculo
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        DetalleMotoVehiculoViewModel(servicioDetalleVehiculo, idAlquiler) as T
}