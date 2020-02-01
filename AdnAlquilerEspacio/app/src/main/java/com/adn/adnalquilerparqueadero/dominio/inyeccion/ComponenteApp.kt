package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler
import dagger.Component

@Component(modules = arrayOf(ModuloApp::class,ConfiguracionModulos::class))
interface ComponenteApp{
    fun inject(servicioAlquiler: ServicioAlquiler)
}