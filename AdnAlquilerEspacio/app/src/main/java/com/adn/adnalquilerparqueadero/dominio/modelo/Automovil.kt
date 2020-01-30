package com.adn.adnalquilerparqueadero.dominio.modelo

const val AUTOMOVIL="AUTOMOVIL"
class Automovil(override var placa:String) :Vehiculo( )
{
    override fun tipoVehiculo()=AUTOMOVIL
}