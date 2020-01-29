package com.adn.adnalquilerparqueadero.dominio.modelo

import java.util.*

class Alquiler(tipoEspacioVehiculo:String,vehiculo: Vehiculo,horaLLegada:Date,horaSalida:Date):IPrecioAlquiler
{
    private var tipoEspacioVehiculo:String?=null
    private var vehiculo: Vehiculo?=null
    private var horaLlegada: Date?=null
    private var horaSalida: Date?=null

    init {
        this.vehiculo = vehiculo
        this.horaLlegada = horaLLegada
        this.horaSalida = horaSalida
        this.tipoEspacioVehiculo = tipoEspacioVehiculo
    }

    override fun calcularValor(calcularAlquiler: CalcularAlquiler) {

    }


}