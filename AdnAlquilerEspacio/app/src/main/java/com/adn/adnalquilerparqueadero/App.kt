package com.adn.adnalquilerparqueadero

import android.app.Application
import com.adn.adnalquilerparqueadero.dominio.inyeccion.DaggerComponenteApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerComponenteApp.builder().application(this)
            .build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}