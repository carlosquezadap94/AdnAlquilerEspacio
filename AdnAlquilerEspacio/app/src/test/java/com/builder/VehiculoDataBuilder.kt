package com.builder

import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo

const val AUTOMOVIL="AUTOMOVIL"
open class VehiculoDataBuilder
{
    var placa:String?=null
    var cc:Int?=null
    var tipoVehiculo:String?=null

    init {
        this.placa = "ABC123"
        this.cc = 200
        this.tipoVehiculo = AUTOMOVIL
    }




    fun build():Vehiculo
        {
            return Vehiculo(placa!!,cc!!,tipoVehiculo!!)
        }





}