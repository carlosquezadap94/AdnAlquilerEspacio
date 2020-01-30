package com.adn.adnalquilerparqueadero.database.alquiler

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.adn.adnalquilerparqueadero.infraestructura.db.AppDatabase
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import kotlinx.coroutines.runBlocking
import org.junit.*

import java.io.IOException
import java.util.*


class AlquilerEntityTest {


    private lateinit var alquilerDao: AlquilerDao
    private lateinit var database: AppDatabase

    private val alquiler = AlquilerEntidad(1,
        "AUTOMOVIL",
        vehiculo = AlquilerEntidad.Vehiculo("123456"),
        horaLlegada = Date(),
        horaSalida = Date(),
        estaActivo = true)


    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun createDb()  = runBlocking {

        val context = androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().targetContext

        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        alquilerDao = database.alquilerDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }


    @Test
    @Throws(Exception::class)
    fun insertUserAndRead()= runBlocking {
        alquilerDao.insert(alquiler)
        val result = alquilerDao.getAlquilerById(1)
        Assert.assertEquals(result.vehiculo!!.placa, result.vehiculo!!.placa)
    }




}