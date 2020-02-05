package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago.AdicionalMoto
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.chainPago.PagoPorTiempo
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject


class ServicioDetalleVehiculo @Inject constructor(alquilerRepo: AlquilerRepositorioImpl) :
    IserviceDetalle {

    var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        this.iAlquilerRepositorioImpl = alquilerRepo
    }

    override fun obtenerAlquiler(id: Int) = iAlquilerRepositorioImpl.obtenerAlquilerPorId(id)


    override suspend fun realizarPago(alquiler: Alquiler) {
        val adicionalMoto = AdicionalMoto()
        val pagoPorTiempo = PagoPorTiempo(adicionalMoto)
        alquiler.precio = pagoPorTiempo.calcularPago(alquiler)
        return iAlquilerRepositorioImpl.actualizarAlquiler(alquiler)
    }


}