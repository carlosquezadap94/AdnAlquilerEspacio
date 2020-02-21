package com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago


import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import java.lang.NullPointerException
import java.util.*

private const val AUTOMOVIL = "AUTOMOVIL"
private const val MOTOCICLETA = "MOTOCICLETA"

private const val VALOR_DIA_CARRO = 8000
private const val VALOR_DIA_MOTO = 6000

private const val VALOR_HORA_CARRO = 1000
private const val VALOR_HORA_MOTO = 500

private val PRECIO_POR_DIA = mapOf(
    AUTOMOVIL to VALOR_DIA_CARRO,
    MOTOCICLETA to VALOR_DIA_MOTO
)

private val PRECIO_POR_HORA = mapOf(
    AUTOMOVIL to VALOR_HORA_CARRO,
    MOTOCICLETA to VALOR_HORA_MOTO
)

class PagoPorTiempo(val siguiente: IHandler) : IHandler, ICalcularTiempo {

    override fun calcularHoras(diaInicio: Date, diaFin: Date): Float {
        val diferencia = diaFin.time - diaInicio.time
        val obtenerFuncionTecho = ((diferencia) * 1.0 / ((60 * 60 * 1000) * 1.0))
        val techo: Int = Math.ceil(obtenerFuncionTecho).toInt()
        if (techo<0f)
            throw ExcepcionNegocio("La fecha de inicio debe ser menor a la fecha final")
        return techo.toFloat()
    }


    override fun calcularPago(alquiler: Alquiler): Float {
        if (alquiler==null)
        {
            throw NullPointerException("Alquiler llega vacio")
        }else
        {
            val horas = calcularHoras(alquiler.horaLlegada!!, alquiler.horaSalida!!)
            val tipoVehiculo = alquiler.vehiculo!!.tipoVehiculo
            var valorPagar: Float
            var dias: Int = (horas / 24).toInt()
            var tHoras: Int = (horas % 24).toInt()

            if (tHoras > 9) {
                dias = dias.inc()
                tHoras = 0
            }

            val precioDia: Int = PRECIO_POR_DIA.get(tipoVehiculo)!! * dias
            val precioHora: Int = PRECIO_POR_HORA.get(tipoVehiculo)!! * tHoras

            valorPagar = precioDia.toFloat() + precioHora.toFloat()

            if (alquiler.vehiculo!!.tipoVehiculo.equals(MOTOCICLETA)) {
                valorPagar = valorPagar.plus(siguiente.calcularPago(alquiler))
            }
            return valorPagar
        }
    }


}