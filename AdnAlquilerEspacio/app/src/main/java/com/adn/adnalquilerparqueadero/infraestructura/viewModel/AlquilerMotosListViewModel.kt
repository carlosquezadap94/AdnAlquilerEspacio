package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio

class AlquilerMotosListViewModel internal constructor( alquilerRepositorio: AlquilerRepositorio):ViewModel()
{
    val motos :LiveData<List<AlquilerEntidad>> =alquilerRepositorio.getAlquilerFromTipoV(MOTOCICLETA)
    val existeMoto = alquilerRepositorio.getAlquilerFromTipoV(MOTOCICLETA)

    companion object{
        private const val MOTOCICLETA ="MOTOCICLETA"
    }
}