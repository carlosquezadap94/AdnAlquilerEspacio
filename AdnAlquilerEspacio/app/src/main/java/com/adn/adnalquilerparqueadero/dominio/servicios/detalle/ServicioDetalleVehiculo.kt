package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import java.util.*
import javax.inject.Inject


const val AUTOMOVIL = "AUTOMOVIL"
const val MOTOCICLETA = "MOTOCICLETA"
const val VALOR_DIA_CARRO = 8000
const val VALOR_DIA_MOTO = 8000

const val VALOR_HORA_CARRO = 1000
const val VALOR_HORA_MOTO = 500

const val VALOR_ADIONAL = 2000


val PRECIO_POR_DIA = mapOf(
    AUTOMOVIL to VALOR_DIA_CARRO,
    MOTOCICLETA to VALOR_DIA_MOTO
)

val PRECIO_POR_HORA = mapOf(
    AUTOMOVIL to VALOR_HORA_CARRO,
    MOTOCICLETA to VALOR_HORA_MOTO
)


class ServicioDetalleVehiculo @Inject constructor(alquilerRepo: AlquilerRepositorioImpl) :
    IserviceDetalle, IServiceDetalleValidaciones {

    var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        this.iAlquilerRepositorioImpl = alquilerRepo
    }

    override fun obtenerAlquiler(id: Int)= iAlquilerRepositorioImpl.obtenerAlquilerPorId(id)


    override suspend fun realizarPago(alquiler: Alquiler) {

        val tiempoTotal = calcularHoras(alquiler.horaLlegada!!,Date())
        val calcularPago = calcularPago(tiempoTotal, alquiler.vehiculo!!.tipoVehiculo!!)
        alquiler.precio = calcularPago + calcularAdicionales(alquiler)
        return iAlquilerRepositorioImpl.actualizarAlquiler(alquiler)
    }


    override fun calcularPago(horas: Float, tipoVehiculo: String): Float {
        val valorPagar: Int
        var dias: Int = (horas / 24).toInt()
        var tHoras: Int = (horas % 24).toInt()
        if (tHoras > 9) {
            dias = dias.inc()
            tHoras = 0
        }


        val precioDia: Int = PRECIO_POR_DIA.get(tipoVehiculo)!! * dias
        val precioHora: Int = PRECIO_POR_HORA.get(tipoVehiculo)!! * tHoras

        valorPagar = precioDia + precioHora

        return valorPagar.toFloat()
    }

    override fun calcularHoras(dia_inicio: Date, dia_fin: Date): Float {

        var diferencia = dia_fin.time - dia_inicio.time
        var obtenerFuncionTecho =  ((diferencia)*1.0/((60 * 60 * 1000)*1.0))
        var techo:Int = Math.ceil(obtenerFuncionTecho).toInt()
        return techo.toFloat()

    }

    override fun calcularAdicionales(alquiler: Alquiler): Float {
        var total = 0f
        if (alquiler.vehiculo!!.tipoVehiculo.equals(MOTOCICLETA) && alquiler.vehiculo!!.cc!! > 500) {
            total = total.plus(2000f)
        }
        return total
    }


}