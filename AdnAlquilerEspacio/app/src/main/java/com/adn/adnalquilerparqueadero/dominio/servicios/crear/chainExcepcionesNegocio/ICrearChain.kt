package com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface ICrearChain {
    fun validarCreacion(alquiler: Alquiler): String
}