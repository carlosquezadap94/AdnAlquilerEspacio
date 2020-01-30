package com.adn.adnalquilerparqueadero.database.alquiler

import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import java.util.*

object AlquilerData {
    fun createUserWithIndex(index: Int) = AlquilerEntidad(
            id = index,
            estaActivo = true,
            horaLlegada = Date(),
            horaSalida = Date(),
            tipoEspacioVehiculo = "AUTOMOVIL",
            vehiculo = AlquilerEntidad.Vehiculo("123456")
    )
}