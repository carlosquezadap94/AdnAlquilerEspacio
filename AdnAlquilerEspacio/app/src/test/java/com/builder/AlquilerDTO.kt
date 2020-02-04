package com.builder

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import net.bytebuddy.asm.Advice
import java.util.*

class AlquilerDTODataBuilder() {


    val vehiculo: Vehiculo
    val horaLlegada: Date

    init {
        this.vehiculo = VehiculoDataBuilder().build()
        this.horaLlegada = Date()
    }

    fun build(): AlquilerDTO
    {
        return AlquilerDTO(vehiculo,horaLlegada)
    }

}