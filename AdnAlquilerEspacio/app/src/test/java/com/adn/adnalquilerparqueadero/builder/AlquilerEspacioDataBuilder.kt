package com.adn.adnalquilerparqueadero.builder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

class AlquilerEspacioDataBuilder {


    var id: Int?=null
    var vehiculo: Vehiculo?=null
    var horaLlegada: Date?= null
    var horaSalida: Date?= null
    var estaActivo: Boolean=true

    init {

        val dateLlegada = "06-Feb-2020 08:00:00"
        val dateSalida = "07-Feb-2020 11:00:00"
        val formatterDate = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
        val horaLlegada: Date = formatterDate.parse(dateLlegada)!!
        val horaSalida:Date = formatterDate.parse(dateSalida)!!

        this.vehiculo = VehiculoDataBuilder().build()
        this.horaLlegada = horaLlegada
        this.horaSalida = horaSalida
        this.id =1
    }

    fun build()= Alquiler(id,vehiculo,horaLlegada,horaSalida,estaActivo)


    fun buildListLiveData(): LiveData<List<Alquiler>> = runBlocking {
        val list = ArrayList<Alquiler>()
        list.add(build())
        val liveDataMutable =  MutableLiveData<List<Alquiler>>(list)
        val liveData: LiveData<List<Alquiler>> =liveDataMutable
        return@runBlocking liveData
    }




}