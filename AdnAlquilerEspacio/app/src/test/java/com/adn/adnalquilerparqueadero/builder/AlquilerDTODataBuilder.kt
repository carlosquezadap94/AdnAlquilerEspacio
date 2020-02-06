package com.adn.adnalquilerparqueadero.builder

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import java.text.SimpleDateFormat
import java.util.*

open class AlquilerDTODataBuilder() {


    var vehiculo: Vehiculo
    var horaLlegada: Date

    init {

        val date = "02-Feb-2020 08:00:00"
        val formatterDate = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
        val date1: Date = formatterDate.parse(date)

        this.vehiculo = VehiculoDataBuilder().build()
        this.horaLlegada = date1
    }

    fun build(): AlquilerDTO
    {
        return AlquilerDTO(vehiculo,horaLlegada)
    }

}