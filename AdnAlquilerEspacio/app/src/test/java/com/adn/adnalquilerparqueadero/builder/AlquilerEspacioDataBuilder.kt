package com.adn.adnalquilerparqueadero.builder

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import java.util.*

class AlquilerEspacioDataBuilder {


    var id: Int?=null
    var vehiculo: Vehiculo?=null
    var horaLlegada: Date?= Date()
    var horaSalida: Date?= Date()
    var estaActivo: Boolean=true

    init {
        this.vehiculo = VehiculoDataBuilder().build()
        this.horaLlegada = Date()
    }

    fun build()= Alquiler(id,vehiculo,horaLlegada,horaSalida,estaActivo)

}