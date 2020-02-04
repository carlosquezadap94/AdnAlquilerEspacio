package com.adn.adnalquilerparqueadero.infraestructura.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
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

    var estaActivo: Boolean=true,

    var precio:Float =0f
){


    companion object {
        fun from(alquiler: Alquiler): AlquilerEntidad {
            return AlquilerEntidad(alquiler.id, alquiler.vehiculo, alquiler.horaLlegada, alquiler.horaSalida, alquiler.estaActivo)
        }
    }

    fun toAlquiler(): Alquiler {
        return Alquiler(id, vehiculo, horaLlegada,horaSalida, estaActivo)
    }
}







