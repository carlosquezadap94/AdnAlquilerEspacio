package com.adn.adnalquilerparqueadero.servicios

import com.adn.adnalquilerparqueadero.builder.AlquilerEspacioDataBuilder
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.testng.Assert

open class ServicioDetalleTest {


    @InjectMocks
    lateinit var servicioDetalleVehiculo: ServicioDetalleVehiculo


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.mock(AlquilerRepositorioImpl::class.java)
    }

    @Test
    fun validarPrecio() {
        //Arrange
        var alquiler = AlquilerEspacioDataBuilder().build()

        //Act
        val valorApagar = servicioDetalleVehiculo.calcularPrecio(alquiler)

        //Assert+
        Assert.assertEquals(valorApagar, 11000f)

    }

}