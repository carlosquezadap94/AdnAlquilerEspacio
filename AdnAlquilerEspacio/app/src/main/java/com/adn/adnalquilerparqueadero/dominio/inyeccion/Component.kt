package com.adn.adnalquilerparqueadero.dominio.inyeccion

import dagger.Component


@Component(modules = [ModuloApp::class, ConfiguracionModulos::class])
interface Component {

}