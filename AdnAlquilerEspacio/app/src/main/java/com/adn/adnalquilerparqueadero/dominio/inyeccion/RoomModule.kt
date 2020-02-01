package com.adn.adnalquilerparqueadero.infraestructura.db

import android.app.Application
import androidx.room.Room
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(app:Application) {

    lateinit var appDatabase:AppDatabase

    init {
        appDatabase =
            Room.databaseBuilder(app, AppDatabase::class.java, "demo-db").build()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }

    @Singleton
    @Provides
    fun providesProductDao(appDatabase: AppDatabase): AlquilerDao? {
        return appDatabase.alquilerDao()
    }

}