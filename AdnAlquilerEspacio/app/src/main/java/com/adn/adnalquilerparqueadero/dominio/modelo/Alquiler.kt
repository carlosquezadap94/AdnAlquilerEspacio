package com.adn.adnalquilerparqueadero.dominio.modelo

import java.util.*

class Alquiler(placa:String,cc:Int,tipoV:String,horaLLegada:Date,horaSalida:Date)
{
    var placa: String?=null
    var cc: Int?=null
    var tipoVehiculo: String?=null
    var horaLlegada: Date?=null
    var horaSalida: Date?=null

    init {
        this.placa = placa
        this.cc = cc
        this.tipoVehiculo = tipoV
        this.horaLlegada = horaLLegada
        this.horaSalida = horaSalida
    }
}