package com.adn.adnalquilerparqueadero.dominio.inyeccion

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import javax.inject.Singleton

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

    @Provides
    @Singleton
    fun app(): Application {
        return application
    }
}