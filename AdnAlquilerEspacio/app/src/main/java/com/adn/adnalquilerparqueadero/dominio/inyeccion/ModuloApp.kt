package com.adn.adnalquilerparqueadero.dominio.inyeccion

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ModuloApp {
    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }
}