package com.adn.adnalquilerparqueadero.infraestructura.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import java.util.*

@Entity(tableName = "alquilerEspacio")
data class AlquilerEntidad(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val tipoEspacioVehiculo:String?=null,
    @Embedded(prefix = "vehiculo_")
    val vehiculo: Vehiculo?=null,
    val horaLlegada: Date?=null,
    val horaSalida: Date?=null,
    val estaActivo: Boolean=true
){
     inner class Vehiculo
    {
         var placa:String?=null
    }
}






