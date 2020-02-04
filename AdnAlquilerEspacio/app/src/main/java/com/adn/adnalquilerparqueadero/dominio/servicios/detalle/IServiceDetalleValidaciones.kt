package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import java.util.*

interface ICalcularPago {
    fun calcularPago(dia_inicio:Date,dia_fin:Date,tipoVehiculo: String)
}