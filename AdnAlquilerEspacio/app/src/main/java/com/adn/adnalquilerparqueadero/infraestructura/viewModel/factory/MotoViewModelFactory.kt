package com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.MotoViewModel

class MotoViewModelFactory(val repositorio: AlquilerRepositorio): ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel> create(modelClass: Class<T>) = MotoViewModel(
        repositorio
    ) as T
}