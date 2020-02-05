package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.VehiculoViewModel

class VehiculoViewModelFactory(private val serviceAlquilerDominio: ServicioCrearAlquiler) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        VehiculoViewModel(serviceAlquilerDominio) as T
}