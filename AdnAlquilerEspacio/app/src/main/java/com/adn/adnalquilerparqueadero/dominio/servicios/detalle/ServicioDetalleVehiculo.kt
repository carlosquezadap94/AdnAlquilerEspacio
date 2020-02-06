package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import androidx.lifecycle.LiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago.AdicionalMoto
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago.PagoPorTiempo
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import java.util.*
import javax.inject.Inject


class ServicioDetalleVehiculo @Inject constructor(alquilerRepo: AlquilerRepositorioImpl) :
    IserviceDetalle {

    var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        this.iAlquilerRepositorioImpl = alquilerRepo
    }

    override fun obtenerAlquiler(id: Int) = iAlquilerRepositorioImpl.obtenerAlquilerPorId(id)

    override suspend fun realizarPago(alquiler: Alquiler): LiveData<Alquiler> {
        alquiler.horaSalida = Date()
        alquiler.precio = calcularPrecio(alquiler)
        return iAlquilerRepositorioImpl.actualizarAlquiler(alquiler)

    }

    override fun calcularPrecio(alquiler: Alquiler): Float {
        val adicionalMoto = AdicionalMoto()
        val pagoPorTiempo = PagoPorTiempo(adicionalMoto)
        return pagoPorTiempo.calcularPago(alquiler)
    }


}