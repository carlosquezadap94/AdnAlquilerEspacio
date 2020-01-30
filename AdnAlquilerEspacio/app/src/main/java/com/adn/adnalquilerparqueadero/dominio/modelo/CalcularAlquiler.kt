package com.adn.adnalquilerparqueadero.dominio.modelo

import java.util.*


public class CalcularAlquiler
{
    fun valorPorVehiculo(vehiculo: Vehiculo,alquiler: Alquiler):Float
    {
        var valor_pagar = 0f


        if (vehiculo is Automovil)
        {

        }else if(vehiculo is Motocicleta)
        {
            var motocicleta = vehiculo
            if (motocicleta.cc!! > 500f)
            valor_pagar.plus(PRECIO_ADICIONAL_MOTO)
        }

        return valor_pagar
    }

    fun calcularDiasparqueo(fechaIngreso:Date,fechaSalida: Date)
    {
        var diferencia = ((fechaSalida.getTime() - fechaIngreso.getTime()) / 1000) as Int

        var dias=0
        var horas=0
        var minutos=0

        if (diferencia > 86400)
        {
            dias = Math.floor(diferencia / 86400.toDouble()).toInt()
            diferencia = diferencia - dias * 86400
        }
        if (diferencia > 3600)
        {
            horas = Math.floor(diferencia / 3600.toDouble()).toInt()
            diferencia = diferencia - horas * 3600
        }
        if (diferencia > 60)
        {
            minutos = Math.floor(diferencia / 60.toDouble()).toInt()
            diferencia = diferencia - minutos * 60
        }
    }

    companion object
    {
        const val PRECIO_ADICIONAL_MOTO = 2000
        const val PRECIO_HORA_MOTO = 500
        const val PRECIO_HORA_CARRO = 1000
        const val PRECIO_DIA_MOTO = 6000
        const val PRECIO_DIA_AUTOMOVIL = 8000


    }
}