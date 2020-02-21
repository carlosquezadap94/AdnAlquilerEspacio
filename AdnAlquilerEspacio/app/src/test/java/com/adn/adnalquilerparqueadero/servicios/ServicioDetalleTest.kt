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
import java.text.SimpleDateFormat
import java.util.*

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


    @Test(expected = ExcepcionNegocio::class)
    fun validarPrecioFechaIncorrecta() {
        //Arrange
        var alquiler = AlquilerEspacioDataBuilder().build()

        val dateSalida = "05-Feb-2020 11:00:00"
        val formatterDate = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
        val horaSalida: Date = formatterDate.parse(dateSalida)!!

        alquiler.horaSalida = horaSalida

        //Act
        var valorApagar = servicioDetalleVehiculo.calcularPrecio(alquiler)

        //Assert
        Assert.assertEquals(valorApagar, 11000f)
    }


    @Test(expected = NullPointerException::class)
    fun validaPrecioNull() {
        //Arrange
        val alquiler_null: Alquiler? = null
        //Act
        servicioDetalleVehiculo.calcularPrecio(alquiler_null!!)
    }

    @Test(expected = NullPointerException::class)
    fun validaPrecioInstanciaSinDatos() {
        //Arrange
        val alquiler = Alquiler()
        //Act
        servicioDetalleVehiculo.calcularPrecio(alquiler)
        //Assert
    }


}