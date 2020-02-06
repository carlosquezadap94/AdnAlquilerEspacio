package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO

interface IserviceCrearAlquiler {
    fun agregarAlquiler(alquilerDTO: AlquilerDTO): Boolean
    fun estaAlquilado(placa: String): Boolean
}