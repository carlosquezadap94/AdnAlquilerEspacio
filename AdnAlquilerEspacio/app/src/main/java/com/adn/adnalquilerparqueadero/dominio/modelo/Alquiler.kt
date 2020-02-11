package com.adn.adnalquilerparqueadero.dominio.modelo

import java.util.*

data class Alquiler(
    var id: Int? = null,
    var vehiculo: Vehiculo? = null,
    var horaLlegada: Date? = null,
    var horaSalida: Date? = null,
    var estaActivo: Boolean = true,
    var precio: Float = 0f
)