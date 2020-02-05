package com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago

import java.util.*

interface ICalcularTiempo {
    fun calcularHoras(dia_inicio: Date, dia_fin: Date): Float
}