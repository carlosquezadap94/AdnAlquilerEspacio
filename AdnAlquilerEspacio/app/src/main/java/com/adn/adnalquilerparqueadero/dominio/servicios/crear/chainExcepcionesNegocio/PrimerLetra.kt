package com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import java.util.*

class PrimerLetra : ICrearChain {
    override fun validarCreacion(alquiler: Alquiler): String {
        val primerLetra = alquiler.vehiculo!!.placa!!.get(0).toString().toUpperCase()
        val calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_WEEK)

        when (day) {
            Calendar.SUNDAY, Calendar.MONDAY -> {
                if (primerLetra.equals("A")) {
                    return "Solo pueden ingresar al parqueadero los días Domingo y Lunes"
                }

            }
        }
        return "true"
    }
}