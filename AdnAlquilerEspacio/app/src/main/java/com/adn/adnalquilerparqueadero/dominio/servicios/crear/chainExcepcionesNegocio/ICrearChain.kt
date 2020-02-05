package com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO

interface ICrearChain {
    fun validarCreacion(alquilerDTO: AlquilerDTO): String
}