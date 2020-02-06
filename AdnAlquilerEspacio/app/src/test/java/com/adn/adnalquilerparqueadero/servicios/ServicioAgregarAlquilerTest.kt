package com.adn.adnalquilerparqueadero.servicios


import com.adn.adnalquilerparqueadero.builder.AlquilerDTODataBuilder
import com.adn.adnalquilerparqueadero.dominio.dto.AlquilerDTO
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.IserviceCrearAlquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.testng.Assert
import javax.inject.Inject


open class ServicioAgregarAlquilerTest {


    @Mock
    lateinit var repositorioImpl:AlquilerRepositorioImpl

    @InjectMocks
    lateinit var servicioCrearCrearAlquiler: ServicioCrearAlquiler

    lateinit var alquilerDTO: AlquilerDTO

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.mock(AlquilerRepositorioImpl::class.java)
    }


    @Test
    fun crearVehiculo() {
        //Arrange
        alquilerDTO = AlquilerDTODataBuilder().build()
        Mockito.`when`(repositorioImpl.crearAlquiler(alquilerDTO)).thenReturn(true)
        Mockito.`when`(repositorioImpl.obtenerCantidadXtipoVehiculo(alquilerDTO.vehiculo.tipoVehiculo!!)).thenReturn("5")
        //Act
        val respuestaAgregar = servicioCrearCrearAlquiler.agregarAlquiler(alquilerDTO)

        //Assert+
        Assert.assertEquals(repositorioImpl.crearAlquiler(alquilerDTO),respuestaAgregar)
    }

    @Test
    fun estaAlquilado()
    {
        //Arrange
        alquilerDTO = AlquilerDTODataBuilder().build()
        Mockito.`when`(repositorioImpl.estaAlquilado(alquilerDTO.vehiculo.placa!!)).thenReturn(false)
        //Act
        val respuestaAgregar = servicioCrearCrearAlquiler.estaAlquilado(alquilerDTO.vehiculo.placa!!)

        //Assert+
        Assert.assertEquals(repositorioImpl.crearAlquiler(alquilerDTO),respuestaAgregar)
    }




}