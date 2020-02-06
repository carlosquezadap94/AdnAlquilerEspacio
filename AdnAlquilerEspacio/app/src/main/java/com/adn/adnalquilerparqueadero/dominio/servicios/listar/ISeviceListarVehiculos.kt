package com.adn.adnalquilerparqueadero.dominio.servicios.listar

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface ISeviceListarVehiculos {

    fun obtenerTodos(): LiveData<List<Alquiler>>
    fun obtenerAlquileTipoV(tipoVehiculo: String): LiveData<List<Alquiler>>
}