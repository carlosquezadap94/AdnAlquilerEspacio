package com.adn.adnalquilerparqueadero.infraestructura.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adn.adnalquilerparqueadero.infraestructura.db.entities.AlquilerEntity

@Dao
interface AlquilerDao {

    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.placa = :placa")
    fun getAlquiler(placa: String): LiveData<AlquilerEntity>


    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.tipoVehiculo = :tipoVehiculo")
    fun getAlquilerFromTV(tipoVehiculo: String): LiveData<List<AlquilerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alquiler: AlquilerEntity)

}