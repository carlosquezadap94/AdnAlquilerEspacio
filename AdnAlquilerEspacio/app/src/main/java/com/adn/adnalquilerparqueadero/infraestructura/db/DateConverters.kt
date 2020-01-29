package com.adn.adnalquilerparqueadero.infraestructura.db

import androidx.room.TypeConverter
import java.util.*


class DateConverters {

    @TypeConverter
    fun toDate(dateLong:Long) = Date(dateLong)

    @TypeConverter
    fun fromDate(date: Date) = date.time

}