package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerMotosListViewModel

class MotosListViewModelFactory(private val repository:AlquilerRepositorio)
    :ViewModelProvider.NewInstanceFactory()
    {
    override fun <T : ViewModel> create(modelClass: Class<T>) = AlquilerMotosListViewModel(
        repository
    ) as T
    }