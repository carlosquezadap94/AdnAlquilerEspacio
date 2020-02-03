package com.adn.adnalquilerparqueadero.dominio.inyeccion

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.adn.adnalquilerparqueadero.infraestructura.db.AppDatabase
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule( context: Context) {

    var context: Context

    init {
        this.context = context
    }

    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app-db"
        ).fallbackToDestructiveMigration().build()
    }



    @Singleton
    @Provides
    fun provideAlquilerDao(db: AppDatabase): AlquilerDao {
        return db.alquilerDao()
    }

}