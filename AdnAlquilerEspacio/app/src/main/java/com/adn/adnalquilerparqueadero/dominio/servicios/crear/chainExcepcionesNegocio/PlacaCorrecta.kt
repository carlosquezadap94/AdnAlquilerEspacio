package com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import java.util.regex.Pattern


private const val AUTOMOVIL = "AUTOMOVIL"
private const val MOTOCICLETA = "MOTOCICLETA"

private const val PATTERN_AUTO = "^[a-zA-Z]{3}[0-9]{3}\$"
private const val PATTERN_MOTO = "^[a-zA-Z]{3}[0-9]{2}[a-zA-Z]\$"

private val PATTERN_PLACA_VEHICULO = mapOf(
    AUTOMOVIL to PATTERN_AUTO,
    MOTOCICLETA to PATTERN_MOTO
)

class PlacaCorrecta(val siguiente: ICrearChain) : ICrearChain {
    override fun validarCreacion(alquilerDTO: AlquilerDTO): String {
        for ((key, value) in PATTERN_PLACA_VEHICULO) {
            if (key.equals(alquilerDTO.vehiculo.tipoVehiculo)) {
                val pattern = Pattern.compile(value)
                val m = pattern.matcher(alquilerDTO.vehiculo.placa!!)
                if (m.matches()) {
                    return siguiente.validarCreacion(alquilerDTO)
                } else {
                    return "Placa no valida para ${alquilerDTO.vehiculo.tipoVehiculo}"
                }

            }
        }
        return "Placa no valida para ${alquilerDTO.vehiculo.tipoVehiculo}"
    }

}