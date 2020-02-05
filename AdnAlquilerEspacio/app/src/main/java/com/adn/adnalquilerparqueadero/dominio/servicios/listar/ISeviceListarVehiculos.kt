package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

interface ISeviceListarVehiculos {

    fun obtenerTodos():  LiveData<List<Alquiler>>
    fun obtenerAlquileTipoV(tipoVehiculo: String): LiveData<List<Alquiler>>
}