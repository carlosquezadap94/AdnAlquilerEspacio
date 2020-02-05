package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.presentacion.actividades.MainActivity
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.AlquilerListFragment
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.CrearAlquilerDialogFragment
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.DetalleAlquilerVehiculo
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CrearAlquilerModule {

    @ContributesAndroidInjector
    abstract fun bindFragmentCrear(): CrearAlquilerDialogFragment


    @ContributesAndroidInjector
    abstract fun bindFragmentListar(): AlquilerListFragment


    @ContributesAndroidInjector
    abstract fun bindFragmentDetalle(): DetalleAlquilerVehiculo

    @ContributesAndroidInjector
    abstract fun bindActivity(): MainActivity
}