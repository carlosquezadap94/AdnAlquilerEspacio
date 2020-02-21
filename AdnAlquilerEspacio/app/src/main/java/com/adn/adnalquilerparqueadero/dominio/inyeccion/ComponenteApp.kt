package com.adn.adnalquilerparqueadero.dominio.inyeccion

import android.app.Application
import com.adn.adnalquilerparqueadero.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ModuloApp::class,
        RoomModule::class,
        CrearAlquilerModule::class
    ]
)
abstract class ComponenteApp {
    abstract fun inject(application: App)



    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ComponenteApp
    }
}