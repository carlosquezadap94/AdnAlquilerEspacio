package com.adn.adnalquilerparqueadero.dominio.interfaz

import com.adn.adnalquilerparqueadero.dominio.modelo.CalcularAlquiler

interface IPrecioAlquiler {
    fun calcularValor(calcularAlquiler: CalcularAlquiler);
}