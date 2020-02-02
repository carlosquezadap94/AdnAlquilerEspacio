package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.dominio.servicios.ServicioAlquiler
import io.reactivex.rxkotlin.toObservable

class AlquilerMotosListViewModel internal constructor():ViewModel()
{




    private var serviceAlquilerDominio: ServicioAlquiler

    init {
        serviceAlquilerDominio =  ServicioAlquiler()
    }

    /*

    val motos:LiveData<List<Alquiler>>  = serviceAlquilerDominio.obtenerVehiculosPorTipo(MOTOCICLETA)
     */



}