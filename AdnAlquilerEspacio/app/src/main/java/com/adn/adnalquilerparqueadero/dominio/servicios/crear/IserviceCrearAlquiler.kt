package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IserviceCrearAlquiler {
    fun agregarAlquiler(alquiler: Alquiler): Boolean
    fun estaAlquilado(placa: String): Boolean
}