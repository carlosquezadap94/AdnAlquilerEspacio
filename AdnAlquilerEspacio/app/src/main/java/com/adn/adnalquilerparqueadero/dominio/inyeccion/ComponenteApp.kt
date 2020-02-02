package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ModuloApp::class,
    ConfiguracionModulos::class,
    RoomModule::class])
public interface ComponenteApp
{
    public fun injectCrear(servicioAlquiler: ServicioCrearCrearAlquiler)
    public fun injectList(servicioAlquiler: ServicioListarVehiculos)
    public fun injectDetalle(servicioAlquiler: ServicioDetalleVehiculo)

}