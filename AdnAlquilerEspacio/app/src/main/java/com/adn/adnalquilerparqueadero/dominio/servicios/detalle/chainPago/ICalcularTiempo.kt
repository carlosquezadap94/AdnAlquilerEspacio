package com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago

import java.util.*

interface ICalcularTiempo {
    fun calcularHoras(diaInicio: Date, diaFin: Date): Float
}