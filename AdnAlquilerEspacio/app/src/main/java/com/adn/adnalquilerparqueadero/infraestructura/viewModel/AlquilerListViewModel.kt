package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.db.entities.AlquilerEntity
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio

class AlquilerListViewModel(val alquilerRepositorio: AlquilerRepositorio):ViewModel() {


    suspend fun getAlquileresTV(tipoVH:String)=alquilerRepositorio.getAlquilerFromTipoV(tipoVH)

}