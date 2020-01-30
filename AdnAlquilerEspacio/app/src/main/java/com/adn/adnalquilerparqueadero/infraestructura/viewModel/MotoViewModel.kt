package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import kotlinx.coroutines.launch

class MotoViewModel(private val alquilerRepositorio: AlquilerRepositorio): ViewModel()
{


     fun agregarAlquiler(alquiler: Alquiler){
        viewModelScope.launch {
            alquilerRepositorio.createAlquiler(alquiler)
        }
    }

     fun placaExiste(placa:String) =
        alquilerRepositorio.estaAlquilado(placa)

}