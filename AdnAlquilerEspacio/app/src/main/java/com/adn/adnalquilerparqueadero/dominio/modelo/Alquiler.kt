package com.adn.adnalquilerparqueadero.dominio.modelo

import java.util.*

class Alquiler(vehiculo: Vehiculo,horaLLegada:Date):IPrecioAlquiler
{
     var vehiculo: Vehiculo?=null
     var horaLlegada: Date?=null
     var horaSalida: Date?=null

    init {
        this.vehiculo = vehiculo
        this.horaLlegada = horaLLegada
    }


    override fun calcularValor(calcularAlquiler: CalcularAlquiler) {

    }


}