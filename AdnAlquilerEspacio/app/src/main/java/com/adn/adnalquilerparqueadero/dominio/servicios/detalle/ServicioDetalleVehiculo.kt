package com.adn.adnalquilerparqueadero.dominio.servicios.detalle

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import javax.inject.Inject


const val AUTOMOVIL = "AUTOMOVIL"
const val MOTOCICLETA = "MOTOCICLETA"
const val VALOR_DIA_CARRO = 8000
const val VALOR_DIA_MOTO = 8000

const val VALOR_HORA_CARRO = 1000
const val VALOR_HORA_MOTO = 500

const val VALOR_ADIONAL = 2000


val PRECIO_POR_DIA = mapOf(
    AUTOMOVIL to VALOR_DIA_CARRO,
    MOTOCICLETA to VALOR_DIA_MOTO
)

val PRECIO_POR_HORA = mapOf(
    AUTOMOVIL to VALOR_HORA_CARRO,
    MOTOCICLETA to VALOR_HORA_MOTO
)


class ServicioDetalleVehiculo : IserviceDetalle {


    @Inject
    lateinit var iAlquilerRepositorioImpl: AlquilerRepositorioImpl


    override suspend fun obtenerAlquiler(id: Int) =
        iAlquilerRepositorioImpl.obtenerAlquilerPorId(id)


    override suspend fun realizarPago(alquiler: Alquiler) {
        iAlquilerRepositorioImpl.actualizarAlquiler(alquiler)
    }


}