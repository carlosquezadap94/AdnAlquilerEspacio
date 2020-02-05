package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import java.lang.Exception
import java.util.*
import java.util.regex.Pattern
import javax.inject.Inject


const val AUTOMOVIL = "AUTOMOVIL"
const val MOTOCICLETA = "MOTOCICLETA"

const val CANTIDAD_MOTO = 10
const val CANTIDAD_AUTOMOVIL = 20

const val PATTERN_AUTO="^[a-zA-Z]{3}[0-9]{3}\$"
const val PATTERN_MOTO="^[a-zA-Z]{3}[0-9]{2}[a-zA-Z]\$"

val VEHICULO_CANTIDAD = mapOf(AUTOMOVIL to CANTIDAD_AUTOMOVIL,
                                    MOTOCICLETA to CANTIDAD_MOTO)

val PATTERN_PLACA_VEHICULO = mapOf(AUTOMOVIL to PATTERN_AUTO,
                                        MOTOCICLETA to PATTERN_MOTO)

class ServicioCrearCrearAlquiler @Inject constructor( alquilerRepo: AlquilerRepositorioImpl):
    IserviceCrearAlquiler,
    IServiceValidaciones {

    var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
        this.iAlquilerRepositorioImpl = alquilerRepo
    }

    override suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    {
        val tipoVehiculo = alquilerDTO.vehiculo.tipoVehiculo
        val cantidad = iAlquilerRepositorioImpl.obtenerCantidadXtipoVehiculo(tipoVehiculo!!)
        val placa = alquilerDTO.vehiculo.placa



        //Validar
        if (validarEspacioDisponible(cantidad,tipoVehiculo!!))
        {
            if (validarPlacaVehiculo(placa!!,tipoVehiculo))
            {
                if (validarPrimerLetra(placa))
                {
                    iAlquilerRepositorioImpl.crearAlquiler(alquilerDTO)
                }else
                {
                    throw ExcepcionNegocio("Solo pueden ingresar al parqueadero los días Domingo y Lunes")
                }
            }
            else
            {
                throw ExcepcionNegocio("Placa no valida para $tipoVehiculo")
            }
        }
        else
        {
            throw ExcepcionNegocio("Parqueadero lleno para $tipoVehiculo")
        }
    }
    override suspend fun estaAlquilado(placa:String): Boolean
    {
        return iAlquilerRepositorioImpl.estaAlquilado(placa)
    }


    override fun validarPlacaVehiculo(placa: String,tipoVehiculo: String): Boolean
    {
        for ((key, value) in PATTERN_PLACA_VEHICULO)
        {
            if (key.equals(tipoVehiculo))
            {
                var pattern = Pattern.compile(value)
                val m = pattern.matcher(placa)
                return m.matches()
            }
        }
        return false
    }
    override fun validarEspacioDisponible(cantidad: String, tipoVehiculo: String): Boolean
    {
        for ((key, value) in VEHICULO_CANTIDAD)
        {
            if (key.equals(tipoVehiculo))
            {
                if (cantidad.toInt()>= value)
                {
                    return false
                }
                return true
            }
        }
        return false
    }
    override fun validarPrimerLetra(letra: String): Boolean
    {
        var primerLetra =  letra.get(0).toString().toUpperCase()
        val calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_WEEK)

        when (day) {
            Calendar.SUNDAY,Calendar.MONDAY ->
            {
                if (primerLetra.equals("A"))
                {
                    return false
                }

            }
        }
        return true
    }
}