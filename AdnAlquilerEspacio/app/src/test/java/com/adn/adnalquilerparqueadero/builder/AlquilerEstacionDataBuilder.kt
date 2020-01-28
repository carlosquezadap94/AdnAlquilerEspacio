package com.adn.adnalquilerparqueadero.builder

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import java.util.*

class AlquilerEstacionDataBuilder {

    var placa: String?=null
    var cc: Int?=null
    var tipoVehiculo: String?=null
    var horaLlegada: Date?=null
    var horaSalida: Date?=null

    constructor()
    {
          this.placa ="ABC123"
          this.cc =200
          this.tipoVehiculo ="MOTOCICLETA"
          this.horaLlegada =Date()
    }


    fun  build()= Alquiler(placa!!,cc!!,tipoVehiculo!!,horaLlegada!!,horaSalida!!)

}