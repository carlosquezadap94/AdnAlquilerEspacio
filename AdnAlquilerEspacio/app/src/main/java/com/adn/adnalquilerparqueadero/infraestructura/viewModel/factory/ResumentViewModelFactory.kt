package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.ViewModelResumen

class ResumentViewModelFactory(private val repository:AlquilerRepositorio)
    :ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel> create(modelClass: Class<T>) = ViewModelResumen(
        repository
    ) as T
}