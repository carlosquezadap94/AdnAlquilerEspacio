package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.presentacion.fragmentos.CrearAlquilerDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CrearAlquilerModule {

    @ContributesAndroidInjector
    abstract fun bindFragment(): CrearAlquilerDialogFragment
}