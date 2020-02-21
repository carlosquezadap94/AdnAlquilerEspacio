package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio.PlacaCorrecta
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.chainExcepcionesNegocio.PrimerLetra
import javax.inject.Inject


private const val AUTOMOVIL = "AUTOMOVIL"
private const val MOTOCICLETA = "MOTOCICLETA"

const val CANTIDAD_MOTO = 10
const val CANTIDAD_AUTOMOVIL = 20

private val VEHICULO_CANTIDAD = mapOf(
    AUTOMOVIL to CANTIDAD_AUTOMOVIL,
    MOTOCICLETA to CANTIDAD_MOTO
)


open class ServicioCrearAlquiler @Inject constructor(alquilerRepo: IAlquilerRepositorio) :
    IserviceCrearAlquiler, IServiceValidaciones {

    private var iAlquilerRepositorioImpl: IAlquilerRepositorio

    init {
        this.iAlquilerRepositorioImpl = alquilerRepo
    }

    override fun agregarAlquiler(alquiler: Alquiler): Boolean {

        val cantidad =
            iAlquilerRepositorioImpl.obtenerCantidadXtipoVehiculo(alquiler.vehiculo!!.tipoVehiculo!!)


        if (validarEspacioDisponible(cantidad, alquiler.vehiculo!!.tipoVehiculo!!)) {
            val primerLetra = PrimerLetra()
            val placaCorrecta = PlacaCorrecta(primerLetra)

            val message = placaCorrecta.validarCreacion(alquiler)
            if (message.equals("true")) {
                return iAlquilerRepositorioImpl.crearAlquiler(alquiler)
            } else {
                throw ExcepcionNegocio(message)
            }
        } else {
            throw ExcepcionNegocio("Parqueadero lleno para ${alquiler.vehiculo!!.tipoVehiculo}")
        }

    }

    override fun estaAlquilado(placa: String): Boolean {
        return iAlquilerRepositorioImpl.estaAlquilado(placa)
    }

    override fun validarEspacioDisponible(cantidad: String, tipoVehiculo: String): Boolean {
        for ((key, value) in VEHICULO_CANTIDAD) {
            if (key.equals(tipoVehiculo)) {
                if (cantidad.toInt() >= value) {
                    return false
                }
                return true
            }
        }
        return false
    }

}