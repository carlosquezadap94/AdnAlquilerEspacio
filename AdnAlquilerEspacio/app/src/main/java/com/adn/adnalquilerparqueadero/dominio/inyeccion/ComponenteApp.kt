package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler
import dagger.Component

@Component
interface ComponenteApp{
    fun inject(servicioAlquiler: ServicioAlquiler)
}