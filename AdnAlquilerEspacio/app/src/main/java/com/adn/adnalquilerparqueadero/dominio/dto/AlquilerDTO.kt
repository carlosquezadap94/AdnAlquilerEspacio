package com.adn.adnalquilerparqueadero.dominio.dto

import com.adn.adnalquilerparqueadero.dominio.modelo.Vehiculo
import java.util.*

data class AlquilerDTO(val vehiculo: Vehiculo, val horaLLegada: Date)
