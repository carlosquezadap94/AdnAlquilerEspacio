package com.adn.adnalquilerparqueadero.servicios


import com.adn.adnalquilerparqueadero.builder.AlquilerEspacioDataBuilder
import com.adn.adnalquilerparqueadero.dominio.excepciones.ExcepcionNegocio
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.testng.Assert


open class ServicioAgregarAlquilerTest {

    @Mock
    lateinit var repositorioImpl: IAlquilerRepositorio

    @InjectMocks
    lateinit var servicioCrearCrearAlquiler: ServicioCrearAlquiler

    lateinit var alquiler: Alquiler

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.mock(IAlquilerRepositorio::class.java)
    }

    @Test
    fun crearVehiculoLunes() {
        //Arrange
        alquiler = AlquilerEspacioDataBuilder().build()
        Mockito.`when`(repositorioImpl.crearAlquiler(alquiler)).thenReturn(true)
        Mockito.`when`(repositorioImpl.obtenerCantidadXtipoVehiculo(alquiler.vehiculo!!.tipoVehiculo!!))
            .thenReturn("5")
        //Act
        val respuestaAgregar = servicioCrearCrearAlquiler.agregarAlquiler(alquiler)

        //Assert
        Assert.assertEquals(repositorioImpl.crearAlquiler(alquiler), respuestaAgregar)
    }

    @Test
    fun estaAlquilado() {
        //Arrange
        alquiler = AlquilerEspacioDataBuilder().build()
        Mockito.`when`(repositorioImpl.estaAlquilado(alquiler.vehiculo!!.placa!!))
            .thenReturn(false)
        //Act
        val respuestaAgregar =
            servicioCrearCrearAlquiler.estaAlquilado(alquiler.vehiculo!!.placa!!)

        //Assert
        Assert.assertEquals(repositorioImpl.crearAlquiler(alquiler), respuestaAgregar)
    }

    @Test(expected = ExcepcionNegocio::class)
    fun espacioLlenoAuto() {
        //Arrange
        alquiler = AlquilerEspacioDataBuilder().build()

        Mockito.`when`(repositorioImpl.crearAlquiler(alquiler)).thenReturn(false)
        Mockito.`when`(repositorioImpl.obtenerCantidadXtipoVehiculo(alquiler.vehiculo!!.tipoVehiculo!!))
            .thenReturn("20")
        //Act
        servicioCrearCrearAlquiler.agregarAlquiler(alquiler)
    }

    @Test(expected = ExcepcionNegocio::class)
    fun espacioLlenoMoto() {
        //Arrange
        alquiler = AlquilerEspacioDataBuilder().build()
        alquiler.vehiculo!!.tipoVehiculo = "MOTOCICLETA"

        Mockito.`when`(repositorioImpl.crearAlquiler(alquiler)).thenReturn(false)
        Mockito.`when`(repositorioImpl.obtenerCantidadXtipoVehiculo(alquiler.vehiculo!!.tipoVehiculo!!))
            .thenReturn("10")
        //Act
        servicioCrearCrearAlquiler.agregarAlquiler(alquiler)
    }


}