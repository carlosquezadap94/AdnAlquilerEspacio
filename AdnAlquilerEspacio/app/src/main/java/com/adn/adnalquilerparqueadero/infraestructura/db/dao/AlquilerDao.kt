package com.adn.adnalquilerparqueadero.infraestructura.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

@Dao
interface AlquilerDao {



    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.vehiculo_placa = :placa AND ae.estaActivo = 1")
    fun getAlquiler(placa: String): LiveData<AlquilerEntidad>



    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.tipoEspacioVehiculo = :tipoVehiculo")
    fun getAlquilerFromTV(tipoVehiculo: String): LiveData<List<AlquilerEntidad>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alquiler: AlquilerEntidad)

}