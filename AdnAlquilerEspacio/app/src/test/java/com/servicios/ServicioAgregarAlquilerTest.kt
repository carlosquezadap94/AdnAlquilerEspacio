package com.servicios


import com.adn.adnalquilerparqueadero.dominio.servicios.crear.IserviceCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import com.builder.AlquilerDTODataBuilder
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.testng.Assert


open class ServicioAgregarAlquilerTest {

    /*
     @Mock
    lateinit var repositorioImpl: AlquilerRepositorioImpl

    @Mock
    lateinit var servicioCrearCrearAlquiler: IserviceCrearAlquiler


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repositorioImpl = Mockito.mock(AlquilerRepositorioImpl::class.java)


    }


    @Test
    fun validarPlaca() {
        // var placa_valida= servicioCrearCrearAlquiler.validarPlacaVehiculo("abc12d","AUTOMOVIL")


        Assert.assertEquals(1, 1)
    }

    @Test
    fun crearVehiculo() {
        val alquilerDTO = AlquilerDTODataBuilder().build()

        Mockito.`when`(repositorioImpl.crearAlquiler(alquilerDTO)).thenReturn(0L)

        Assert.assertEquals(
            servicioCrearCrearAlquiler.agregarAlquiler(alquilerDTO),
            repositorioImpl.crearAlquiler(alquilerDTO)
        )
    }

     */


}