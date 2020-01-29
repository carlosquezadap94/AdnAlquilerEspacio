package com.adn.adnalquilerparqueadero.infraestructura.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adn.adnalquilerparqueadero.infraestructura.db.dao.AlquilerDao
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

@Database(entities = [AlquilerEntidad::class], version = 10, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class AppDatabase:RoomDatabase()
{
    abstract fun alquilerDao(): AlquilerDao


    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null
        val DATABASE_NAME = "alquileres-db"

        fun getInstance(context: Context): AppDatabase
        {
            return instance ?: synchronized(this)
            {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase
        {
            return Room.databaseBuilder(context,
                AppDatabase::class.java,
                DATABASE_NAME)
                .build()
        }
    }
}