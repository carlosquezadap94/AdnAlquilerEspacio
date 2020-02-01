package com.adn.adnalquilerparqueadero.dominio.modelo

import androidx.room.Embedded
import java.util.*

class Alquiler (
    var id: Int?=null,
    var vehiculo: Vehiculo?=null,
    var horaLlegada: Date?= Date(),
    var horaSalida: Date?= Date(),
    var estaActivo: Boolean=true
)