package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler

interface IserviceDetalle {
    fun obtenerAlquiler(id: Int): Alquiler
    suspend fun realizarPago(alquiler: Alquiler):LiveData<Alquiler>
    fun calcularPrecio(alquiler: Alquiler):Float
}