package com.builder

import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo

const val AUTOMOVIL="AUTOMOVIL"
class VehiculoDataBuilder
{
    var placa:String?=null
    var cc:Int?=null
    var tipoVehiculo:String?=null

    init {
        this.placa = "ABC123"
        this.cc = cc
        this.tipoVehiculo = AUTOMOVIL
    }




    public fun build():Vehiculo = Vehiculo(placa!!,cc!!,tipoVehiculo!!)





}