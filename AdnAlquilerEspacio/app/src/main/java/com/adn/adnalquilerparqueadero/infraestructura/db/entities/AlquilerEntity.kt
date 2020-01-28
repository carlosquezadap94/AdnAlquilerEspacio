package com.adn.adnalquilerparqueadero.infraestructura.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "alquilerEspacio")
data class AlquilerEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val placa: String?=null,
    val cc: String?=null,
    val tipoVehiculo: String?=null,
    val horaLlegada: Date?=null,
    val horaSalida: Date?=null
)




