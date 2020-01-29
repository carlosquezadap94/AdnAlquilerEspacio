package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio

class MotosListViewModel(val alquilerRepositorio: AlquilerRepositorio):ViewModel()
{
    suspend fun getAlquileresTV(tipoVH:String)=alquilerRepositorio.getAlquilerFromTipoV(tipoVH)

}