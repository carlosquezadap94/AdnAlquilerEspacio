package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel

class VehiculosListViewModelFactory(private val servicioListarVehiculos: ServicioListarVehiculos) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        AlquilerListViewModel(servicioListarVehiculos) as T
}