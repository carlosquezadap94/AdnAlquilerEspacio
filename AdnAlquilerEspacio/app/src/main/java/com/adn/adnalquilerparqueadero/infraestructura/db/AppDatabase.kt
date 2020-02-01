package com.adn.adnalquilerparqueadero.infraestructura.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

@Database(entities = [AlquilerEntidad::class], version = 10, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class AppDatabase:RoomDatabase()
{
    abstract fun alquilerDao(): AlquilerDao
}