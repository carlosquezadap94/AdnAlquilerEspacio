package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalleMotoVehiculoViewModel (val alquilerRepositorioImpl: AlquilerRepositorioImpl, val idAlquiler:Int):ViewModel()
{

    val alquiler = alquilerRepositorioImpl.obtenerAlquilerPorId(idAlquiler)

    fun pagarAlquiler(alquiler: AlquilerEntidad)
    {
        GlobalScope.launch()
        {
         //   alquilerRepositorio.actualizarAlquiler(alquiler)
        }
    }
}