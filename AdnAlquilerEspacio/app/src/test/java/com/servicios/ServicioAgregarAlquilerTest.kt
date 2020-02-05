package com.servicios

import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock


class ServicioAgregarAlquilerTest {


    @Mock
    lateinit var repositorioImpl: IAlquilerRepositorio

    @InjectMocks
    lateinit var servicioCrearCrearAlquiler:ServicioCrearCrearAlquiler



    //Se ejecuta cada vez que se realiza un test
    @Test
    fun alquilarVehiculo()
    {

    }




    @Test
    fun obtenerVehiculo()
    {
        //Arrange

        //assert+
        assertEquals(1, 1)
    }




    /*
    @Test
    suspend fun alquilarEspacio() {
        //arrange
        val alquilerDTO = AlquilerDTODataBuilder().build()
        var id_repo = repositorioAlquiler!!.crearAlquiler(alquilerDTO)
        var id_servicio = servicioAlquilerDominio!!.agregarAlquiler(alquilerDTO)

        Mockito.`when`(repositorioAlquiler.crearAlquiler(alquilerDTO)).thenReturn(id_repo)

        //assert+
        assertEquals(id_repo, id_servicio
        )
    }
     */

















    /*

    @Test
    fun devolverVehiculoCorrecto() { //arrange
        val alquiler: AlquilarVehiculo = AlquilarVehiculoDataBuilder().build()
        val respuestaRepositorioAlquiler: MutableLiveData<RespuestaServicioGet> =
            MutableLiveData<RespuestaServicioGet>()
        val respuestaPost: RespuestaServicioGet =
            RespuestaServicioGetDataBuilder().build("Operacion exitosa")
        respuestaRepositorioAlquiler.setValue(respuestaPost)
        Mockito.`when`(repositorioAlquiler.devolver(alquiler.getVehiculo().getPlaca()))
            .thenReturn(respuestaRepositorioAlquiler)
        //act
        val respuestaServicioAlquilerDominio: MutableLiveData<RespuestaServicioGet> =
            servicioAlquilerDominio.devolver(alquiler.getVehiculo().getPlaca())
        //assert
        assertEquals(
            respuestaRepositorioAlquiler.getValue().getObjeto(),
            respuestaServicioAlquilerDominio.getValue().getObjeto()
        )
    }

    @Test
    fun devolverVehiculoIncorrecto() { //arrange
        val alquiler: AlquilarVehiculo = AlquilarVehiculoDataBuilder().build()
        val respuestaRepositorioAlquiler: MutableLiveData<RespuestaServicioGet> =
            MutableLiveData<RespuestaServicioGet>()
        val respuestaPost: RespuestaServicioGet =
            RespuestaServicioGetDataBuilder().build("Vehiculo no encontrado")
        respuestaRepositorioAlquiler.setValue(respuestaPost)
        Mockito.`when`(repositorioAlquiler.devolver(alquiler.getVehiculo().getPlaca()))
            .thenReturn(respuestaRepositorioAlquiler)
        //act
        val respuestaServicioAlquilerDominio: MutableLiveData<RespuestaServicioGet> =
            servicioAlquilerDominio.devolver(alquiler.getVehiculo().getPlaca())
        //assert
        assertEquals(
            respuestaRepositorioAlquiler.getValue().getObjeto(),
            respuestaServicioAlquilerDominio.getValue().getObjeto()
        )
    }
     */


}