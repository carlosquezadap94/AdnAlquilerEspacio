package com.adn.adnalquilerparqueadero.servicios

import com.adn.adnalquilerparqueadero.builder.AlquilerEspacioDataBuilder
import com.adn.adnalquilerparqueadero.dominio.servicios.listar.ServicioListarVehiculos
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.testng.Assert

class ServicioListarAlquilerTest {

    @Mock
    lateinit var repositorioImpl: AlquilerRepositorioImpl

    @InjectMocks
    lateinit var servicioListarVehiculos: ServicioListarVehiculos


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.mock(AlquilerRepositorioImpl::class.java)
    }


    @Test
    fun listarVehiculos() {
        //Arrange

        Mockito.`when`(repositorioImpl.obtenerTodos())
            .thenReturn(AlquilerEspacioDataBuilder().buildListLiveData())
        //Act
        val respuestaAgregar = servicioListarVehiculos.obtenerTodos()

        //Assert
        Assert.assertEquals(
            repositorioImpl.obtenerTodos().value!!.get(0).id,
            respuestaAgregar.value!!.get(0).id
        )
    }


    @Test
    fun validarTamanio() {
        //Arrange
        Mockito.`when`(repositorioImpl.obtenerTodos())
            .thenReturn(AlquilerEspacioDataBuilder().buildListLiveData())
        //Act
        val respuestaAgregar = servicioListarVehiculos.obtenerTodos().value!!.size

        //Assert
        Assert.assertEquals(
            repositorioImpl.obtenerTodos().value!!.size,
            respuestaAgregar
        )
    }


}