package com.servicios

import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.ServicioCrearCrearAlquiler
import com.builder.AlquilerEspacioDataBuilder
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner.Silent::class)
class ServicioAgregarAlquilerTest {


    @Mock
    private lateinit var repositorioAlquiler:IAlquilerRepositorio

    @InjectMocks
    private lateinit var servicioAlquilerDominio: ServicioCrearCrearAlquiler

    @Test
    fun devolverVehiculoCorrecto() {
        //arrange
        val alquiler: Alquiler = AlquilerEspacioDataBuilder().build()






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