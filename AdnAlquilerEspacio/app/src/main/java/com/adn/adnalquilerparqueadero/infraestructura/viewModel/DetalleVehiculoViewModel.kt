package com.adn.adnalquilerparqueadero.infraestructura.viewModel

import androidx.lifecycle.ViewModel
import com.adn.adnalquilerparqueadero.infraestructura.db.entidades.AlquilerEntidad
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalleMotoVehiculoViewModel ( val idAlquiler:Int):ViewModel()
{



    fun pagarAlquiler(alquiler: AlquilerEntidad)
    {
        GlobalScope.launch()
        {
         //   alquilerRepositorio.actualizarAlquiler(alquiler)
        }
    }
}