package com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler


interface IHandler {
    fun calcularPago(alquiler: Alquiler): Float
}