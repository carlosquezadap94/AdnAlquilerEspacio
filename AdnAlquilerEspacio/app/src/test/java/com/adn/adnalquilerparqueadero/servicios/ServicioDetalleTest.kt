package com.adn.adnalquilerparqueadero.servicios

import com.adn.adnalquilerparqueadero.builder.AlquilerEspacioDataBuilder
import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.detalle.ServicioDetalleVehiculo
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.testng.Assert
import java.lang.NullPointerException

open class ServicioDetalleTest {


    @Mock
    lateinit var repositorioImpl: AlquilerRepositorioImpl

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
        var valorApagar = servicioDetalleVehiculo.calcularPrecio(alquiler)

        //Assert
        Assert.assertEquals(valorApagar, 11000f)

    }


    @Test(expected = NullPointerException::class)
    fun validaPrecioNull()
    {
        //Arrange
        val alquiler_null: Alquiler? = null
        //Act
        val valorApagar = servicioDetalleVehiculo.calcularPrecio(alquiler_null!!)
    }

    @Test(expected = NullPointerException::class)
    fun validaPrecioInstanciaSinDatos()
    {
        //Arrange
        val alquiler= Alquiler()
        //Act
        val valorApagar = servicioDetalleVehiculo.calcularPrecio(alquiler)
        //Assert
    }

}