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


        //TODO Validar coplamiento
        if (validarEspacioDisponible(cantidad,tipoVehiculo!!))
        {
            if (validarPlacaVehiculo(placa!!,tipoVehiculo))
            {
                iAlquilerRepositorioImpl.crearAlquiler(alquilerDTO)
            }else
            {
                throw ExcepcionNegocio("Placa no valida para $tipoVehiculo")
            }
        }else
        {
            throw ExcepcionNegocio("Parqueadero lleno para $tipoVehiculo")
        }


    }

    override fun obtenerVehiculosPorTipo(tipoVehiculo: String)=
         iAlquilerRepositorioImpl.getAlquilerFromTipoV(tipoVehiculo)

    override fun estaAlquilado(placa:String): Boolean
    {
        return iAlquilerRepositorioImpl.estaAlquilado(placa)
    }


    //Todo validar con MAP
    override fun validarPlacaVehiculo(placa: String,tipoVehiculo: String): Boolean {

        var pattern:Pattern
        if (tipoVehiculo.equals(AUTOMOVIL))
        {
            pattern = Pattern.compile("^[a-zA-Z]{3}[0-9]{3}\$")
        }else
        {
            pattern = Pattern.compile("^[a-zA-Z]{3}[0-9]{2}[a-zA-Z]\$")
        }
        var m = pattern.matcher(placa)
        return m.matches()
    }
    override fun validarEspacioDisponible(cantidad: String, tipoVehiculo: String): Boolean {
        var tope: Int?
        if (tipoVehiculo.equals(AUTOMOVIL))
        {
            tope = CANTIDAD_AUTOMOVIL
        }else{
            tope = CANTIDAD_MOTO
        }

        if (cantidad.toInt()>=tope)
        {
            return false
        }
        return true
    }


}