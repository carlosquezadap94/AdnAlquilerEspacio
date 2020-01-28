package com.adn.adnalquilerparqueadero.infraestructura.db

import androidx.room.TypeConverter
import java.util.*


class Converters {




    @TypeConverter
    fun toDate(dateLong:Long) = Date(dateLong)

    @TypeConverter
    fun fromDate(date: Date) = date.time

}