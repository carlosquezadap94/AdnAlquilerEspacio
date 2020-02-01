package com.adn.adnalquilerparqueadero.dominio.inyeccion

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication

@Module
class ModuloApp(var application: DaggerApplication) {

    @Provides
    fun provideDaggerApplication(): DaggerApplication {
        return application
    }

    @Provides
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }

}