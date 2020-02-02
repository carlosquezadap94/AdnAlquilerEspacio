package com.adn.adnalquilerparqueadero.dominio.servicios.crear

import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.inyeccion.DaggerComponenteApp
import com.adn.adnalquilerparqueadero.dominio.servicios.IServiceValidaciones
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import java.util.regex.Pattern
import javax.inject.Inject


const val AUTOMOVIL = "AUTOMOVIL"
const val MOTOCICLETA = "MOTOCICLETA"
const val CANTIDAD_MOTO = 10
const val CANTIDAD_AUTOMOVIL = 20



class ServicioCrearCrearAlquiler :
    IserviceCrearAlquiler,
    IServiceValidaciones {

     @Inject public lateinit var iAlquilerRepositorioImpl: AlquilerRepositorioImpl

    init {
       val component = DaggerComponenteApp.builder().build()
        component.injectCrear(this)
    }

    override suspend fun agregarAlquiler(alquilerDTO: AlquilerDTO)
    {
        val tipoVehiculo = alquilerDTO.vehiculo.tipoVehiculo
        val cantidad = iAlquilerRepositorioImpl.obtenerCantidadXtipoVehiculo(AUTOMOVIL)
        val placa = alquilerDTO.vehiculo.placa

        //TODO Corregir coplamiento
        if (tipoVehiculo.equals(AUTOMOVIL))
        {
            if (cantidad.toInt()< CANTIDAD_AUTOMOVIL)
            {
                if (validarPlacaCarro(placa!!))
                {
                    iAlquilerRepositorioImpl.crearAlquiler(alquilerDTO)
                }
                else
                {
                    throw ExcepcionNegocio("Placa automovil no autorizada")
                }
            }else
            {
                throw ExcepcionNegocio("Parqueadero lleno")
            }
        }
        else if (tipoVehiculo.equals(MOTOCICLETA))
        {
            if (cantidad.toInt()< CANTIDAD_MOTO)
            {
                if (validarPlacaMoto(placa!!))
                {
                    iAlquilerRepositorioImpl.crearAlquiler(alquilerDTO)
                }
                else
                {
                    throw ExcepcionNegocio("Placa motocicleta no autorizada")
                }
            }else
            {
                throw ExcepcionNegocio("Parqueadero lleno")
            }
        }
    }

    override fun obtenerVehiculosPorTipo(tipoVehiculo: String)=
         iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)

    override fun estaAlquilado(placa:String): Boolean
    {
        return iAlquilerRepositorioImpl.estaAlquilado(placa)
    }

    override fun validarPlacaMoto(placa: String): Boolean {

        var pattern = Pattern.compile("^[a-zA-Z]{3}[0-9]{3}\$")
        var m = pattern.matcher("ABC123")
        return m.matches()
    }

    override fun validarPlacaCarro(placa: String): Boolean {

        var pattern = Pattern.compile("^[a-zA-Z]{3}[0-9]{2}[a-zA-Z]\$")
        var m = pattern.matcher("ABC12E")
        return m.matches()
    }




}