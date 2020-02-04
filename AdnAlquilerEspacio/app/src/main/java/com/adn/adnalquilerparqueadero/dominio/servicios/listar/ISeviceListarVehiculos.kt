package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface ISeviceListarVehiculos
{


    suspend fun obtenerAlquileTipoV(tipoVehiculo:String):List<Alquiler>
}