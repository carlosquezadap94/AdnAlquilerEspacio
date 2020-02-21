package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler

class VehiculoViewModel(private val serviceAlquilerDominio: ServicioCrearAlquiler) :
    ViewModel() {

    fun agregarAlquiler(alquiler: Alquiler):Boolean {
      return  serviceAlquilerDominio.agregarAlquiler(alquiler)
    }

    fun placaExiste(placa: String): Boolean {
        return serviceAlquilerDominio.estaAlquilado(placa)
    }

}


