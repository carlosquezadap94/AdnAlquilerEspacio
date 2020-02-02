package com.adn.adnalquilerparqueadero.dominio.servicios

interface IServiceValidaciones {
    fun validarPlacaMoto(placa:String):Boolean
    fun validarPlacaCarro(placa:String):Boolean
}