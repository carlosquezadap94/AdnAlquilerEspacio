package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.ViewModelResumen



class ResumentViewModelFactory(private val repository:AlquilerRepositorioImpl)
    :ViewModelProvider.NewInstanceFactory()
{


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = ViewModelResumen(repository) as T
}