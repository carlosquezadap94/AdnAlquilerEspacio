package com.adn.adnalquilerparqueadero.presentacion.actividades

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindActivity():MainActivity
}