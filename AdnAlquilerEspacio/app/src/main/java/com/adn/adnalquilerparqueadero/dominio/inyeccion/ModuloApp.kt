package com.adn.adnalquilerparqueadero.dominio.inyeccion

import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication

@Module
class ModuloApp(applicationD:DaggerApplication)
{
    var application: DaggerApplication
    init {
        application = applicationD
    }

    @Provides
    fun provideDaggerApplication()=application

    @Provides
    fun provideApplicationContext()=application.applicationContext

}