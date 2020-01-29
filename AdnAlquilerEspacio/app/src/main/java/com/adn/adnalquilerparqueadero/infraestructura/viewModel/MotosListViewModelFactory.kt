package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio

class MotosListViewModelFactory(private val repository:AlquilerRepositorio)
    :ViewModelProvider.NewInstanceFactory()
    {
    override fun <T : ViewModel> create(modelClass: Class<T>) = MotosListViewModel(repository) as T
    }