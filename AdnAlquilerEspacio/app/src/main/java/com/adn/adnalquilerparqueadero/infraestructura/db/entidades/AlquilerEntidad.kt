package com.adn.adnalquilerparqueadero.infraestructura.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import java.util.*

@Entity(tableName = "alquilerEspacio")
data class AlquilerEntidad(

    @PrimaryKey(autoGenerate = true)
    var id: Int?=null,

    @Embedded(prefix = "vehiculo_")
    var vehiculo: Vehiculo?=null,

    var horaLlegada: Date?= Date(),

    var horaSalida: Date?=Date(),

    var estaActivo: Boolean=true
)







