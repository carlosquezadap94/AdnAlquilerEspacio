package com.adn.adnalquilerparqueadero.utilities

import android.content.Context
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.AlquilerMotosListViewModel
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.MotoViewModel
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.MotoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.MotosListViewModelFactory

object InjectUtils {


    fun provideAlquilerMotosViewModelFactoy(
        context: Context
    ): MotosListViewModelFactory {
        return MotosListViewModelFactory()
    }

    fun provideMotoViewModelFactoy(
        context: Context
    ): MotoViewModelFactory {
        return MotoViewModelFactory()
    }



}