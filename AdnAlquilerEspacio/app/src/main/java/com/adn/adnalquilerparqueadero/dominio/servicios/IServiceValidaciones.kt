package com.adn.adnalquilerparqueadero.dominio.servicios

interface IServiceValidaciones {
    fun validarPlacaVehiculo(placa:String,tipoVehiculo:String):Boolean
    fun validarEspacioDisponible(cantidad:String,tipoVehiculo:String):Boolean
}