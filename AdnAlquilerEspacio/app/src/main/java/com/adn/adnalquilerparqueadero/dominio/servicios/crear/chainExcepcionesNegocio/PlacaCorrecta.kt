package com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import java.util.regex.Pattern


private const val AUTOMOVIL = "AUTOMOVIL"
private const val MOTOCICLETA = "MOTOCICLETA"

private const val EXPRE_REGU_AUTO = "^[a-zA-Z]{3}[0-9]{3}\$"
private const val EXPRE_REGU_MOTO = "^[a-zA-Z]{3}[0-9]{2}[a-zA-Z]\$"

private val PATTERN_PLACA_VEHICULO = mapOf(
    AUTOMOVIL to EXPRE_REGU_AUTO,
    MOTOCICLETA to EXPRE_REGU_MOTO
)

class PlacaCorrecta(val siguiente: ICrearChain) : ICrearChain {
    override fun validarCreacion(alquiler: Alquiler): String {
        for ((key, value) in PATTERN_PLACA_VEHICULO) {
            if (key.equals(alquiler.vehiculo!!.tipoVehiculo)) {
                val pattern = Pattern.compile(value)
                val m = pattern.matcher(alquiler.vehiculo!!.placa!!)
                if (m.matches()) {
                    return siguiente.validarCreacion(alquiler)
                } else {
                    return "Placa no valida para ${alquiler.vehiculo!!.tipoVehiculo}"
                }

            }
        }
        return "Placa no valida para ${alquiler.vehiculo!!.tipoVehiculo}"
    }

}