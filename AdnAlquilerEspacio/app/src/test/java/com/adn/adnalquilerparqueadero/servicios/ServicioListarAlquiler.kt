package com.adn.adnalquilerparqueadero.servicios

import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import org.mockito.InjectMocks
import org.mockito.Mock

class ServicioListarAlquiler {

    @Mock
    lateinit var repositorioImpl: AlquilerRepositorioImpl

    @InjectMocks
    lateinit var servicioCrearCrearAlquiler: ServicioCrearAlquiler


}