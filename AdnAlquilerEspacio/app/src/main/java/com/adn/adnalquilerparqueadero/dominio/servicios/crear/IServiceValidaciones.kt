package com.adn.adnalquilerparqueadero.dominio.servicios.crear

interface IServiceValidaciones {
    fun validarEspacioDisponible(cantidad: String, tipoVehiculo: String): Boolean
}