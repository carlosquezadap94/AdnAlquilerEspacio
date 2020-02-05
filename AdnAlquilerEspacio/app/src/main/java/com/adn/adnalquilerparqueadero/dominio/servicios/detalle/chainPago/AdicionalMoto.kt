package com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

const val VALOR_ADIONAL = 2000f

class AdicionalMoto : IHandler {
    override fun calcularPago(alquiler: Alquiler): Float {
        if (alquiler.vehiculo!!.cc!! > 500) {
            return VALOR_ADIONAL
        }
        return 0f
    }
}