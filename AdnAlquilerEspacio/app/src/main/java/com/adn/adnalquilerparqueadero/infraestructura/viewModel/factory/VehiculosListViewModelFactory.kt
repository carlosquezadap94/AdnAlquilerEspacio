package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerListViewModel

class VehiculosListViewModelFactory()
    :ViewModelProvider.NewInstanceFactory()
    {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>)
                = AlquilerListViewModel() as T
    }