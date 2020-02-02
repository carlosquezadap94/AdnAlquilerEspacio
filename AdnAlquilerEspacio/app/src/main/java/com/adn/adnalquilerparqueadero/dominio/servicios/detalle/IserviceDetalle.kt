package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IserviceDetalle {
    fun obtenerAlquiler(id:Int):Alquiler
    fun realizarPago(alquilerId:Int)
}