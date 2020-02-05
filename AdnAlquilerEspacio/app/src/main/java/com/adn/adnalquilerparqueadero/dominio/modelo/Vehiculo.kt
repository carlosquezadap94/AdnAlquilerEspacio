package com.adn.adnalquilerparqueadero.dominio.modelo

/*
En Kotlin, todas las clases son finales por defecto,
es decir, no pueden heredarse de forma predeterminada.
Esto es opuesto a lo que aprendimos en Java. En Java,
 debes hacer que tu clase finalice explícitamente.
Por lo tanto, para que una clase sea heredable para
las otras clases, debe marcarla con la palabra clave abierta;
 de lo contrario, recibirá un error que dice "el tipo es final,
  por lo que no se puede heredar ".
 */
open class Vehiculo(placa: String, cc: Int, tipoVehiculo: String) {
    var placa: String? = null
    var cc: Int? = null
    var tipoVehiculo: String? = null

    init {
        this.placa = placa
        this.cc = cc
        this.tipoVehiculo = tipoVehiculo
    }
}