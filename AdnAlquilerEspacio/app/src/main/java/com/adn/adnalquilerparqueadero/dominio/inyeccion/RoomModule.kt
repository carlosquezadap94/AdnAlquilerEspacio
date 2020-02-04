package com.adn.adnalquilerparqueadero.dominio.inyeccion

import android.content.Context
import androidx.room.Room
import com.adn.adnalquilerparqueadero.infraestructura.db.AppDatabase
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app-db"
        ).fallbackToDestructiveMigration().allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideAlquilerDao(db: AppDatabase): AlquilerDao {
        return db.alquilerDao()
    }


    @Provides
    fun alquilerRepo(alquilerDao: AlquilerDao): AlquilerRepositorioImpl {
        return AlquilerRepositorioImpl(alquilerDao)
    }

}