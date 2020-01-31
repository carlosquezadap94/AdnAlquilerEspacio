package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.dominio.modelo.Alquiler
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalleMotoVehiculoViewModel (val alquilerRepositorio: AlquilerRepositorio,val idAlquiler:Int):ViewModel()
{

    val alquiler = alquilerRepositorio.obtenerAlquilerPorId(idAlquiler)

    fun pagarAlquiler(alquiler: AlquilerEntidad)
    {
        GlobalScope.launch()
        {
            alquilerRepositorio.actualizarAlquiler(alquiler)
        }
    }
}