package com.adn.adnalquilerparqueadero.infraestructura.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad

@Dao
interface AlquilerDao {
    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.vehiculo_placa = :placa AND ae.estaActivo = 1")
    fun getAlquiler(placa: String): LiveData<AlquilerEntidad>

    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.id = :id AND ae.estaActivo = 1")
    fun getAlquilerByIdLiveData(id:Int):  LiveData<AlquilerEntidad>

    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.id = :id AND ae.estaActivo = 1")
    fun getAlquilerById(id:Int):   LiveData<AlquilerEntidad>

    @Query("SELECT EXISTS(SELECT 1 FROM alquilerEspacio ae WHERE ae.vehiculo_placa = :placa AND ae.estaActivo = 1 LIMIT 1 )")
    fun estaAlquilado(placa: String):LiveData<Boolean>

    @Query("SELECT * FROM alquilerEspacio ae WHERE ae.tipoEspacioVehiculo = :tipoVehiculo AND ae.estaActivo = 1")
    fun getAlquilerFromTV(tipoVehiculo: String): LiveData<List<AlquilerEntidad>>

    @Query("SELECT COUNT(*) FROM alquilerEspacio ae WHERE ae.tipoEspacioVehiculo = :tipoVehiculo AND ae.estaActivo = 1")
    fun obtenerCantidadPorTV(tipoVehiculo: String): LiveData<String>

    @Update
    fun actualizarAlquiler(alquiler: AlquilerEntidad)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alquiler: AlquilerEntidad)

}