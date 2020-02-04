package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import java.util.*

interface IServiceDetalleValidaciones {
    fun calcularPago(horas:Float,tipoVehiculo: String):Float
    fun calcularHoras(dia_inicio:Date,dia_fin:Date):Float
    fun calcularAdicionales(alquiler: Alquiler):Float
}