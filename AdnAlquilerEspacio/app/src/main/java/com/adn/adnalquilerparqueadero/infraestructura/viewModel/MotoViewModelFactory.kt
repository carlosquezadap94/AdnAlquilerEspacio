package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio

class MotoViewModelFactory(val repositorio: AlquilerRepositorio,val alquiler:Alquiler): ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel> create(modelClass: Class<T>) = MotoViewModel(repositorio) as T
}