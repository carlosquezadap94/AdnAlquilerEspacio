package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ModuloApp::class,
    ConfiguracionModulos::class,
    RoomModule::class])
public interface ComponenteApp
{
    public fun inject(servicioAlquiler: ServicioAlquiler)

}