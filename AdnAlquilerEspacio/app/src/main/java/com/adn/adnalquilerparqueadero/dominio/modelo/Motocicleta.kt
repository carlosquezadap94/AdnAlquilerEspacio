package com.adn.adnalquilerparqueadero.dominio.modelo



const val MOTOCICLETA="MOTOCICLETA"
public class Motocicleta( cc:Int, override var placa: String):Vehiculo()
{
    var cc:Int?=null
        //Implementacion por defecto en kotlin
        get() = field
        set(value) {
            field =value
        }
    override fun tipoVehiculo()=MOTOCICLETA
}