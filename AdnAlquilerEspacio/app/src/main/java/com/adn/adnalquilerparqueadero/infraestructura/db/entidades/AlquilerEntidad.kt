package com.adn.adnalquilerparqueadero.infraestructura.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import java.util.*

@Entity(tableName = "alquilerEspacio")
class AlquilerEntidad(
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null,
    var tipoEspacioVehiculo:String?=null,
    @Embedded(prefix = "vehiculo_")
    var vehiculo: Vehiculo?=null,
    var horaLlegada: Date?= Date(),
    var horaSalida: Date?=Date(),
    var estaActivo: Boolean=true
)
{
    open class Vehiculo( placa:String)
    {
        var placa:String?=null
        init {
            this.placa = placa
        }
    }


}






