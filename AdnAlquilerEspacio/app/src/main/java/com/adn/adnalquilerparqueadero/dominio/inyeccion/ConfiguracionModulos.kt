package com.adn.adnalquilerparqueadero.dominio.inyeccion

import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.repositorioImpl.AlquilerRepositorioImpl
import dagger.Binds
import dagger.Module

@Module
public abstract class ConfiguracionModulos
{
    @Binds
    public abstract fun repositorioAlquiler(repositorioImpl: AlquilerRepositorioImpl):IAlquilerRepositorio
}