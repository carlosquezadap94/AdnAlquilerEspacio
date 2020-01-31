/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.utilities

import android.content.Context
import com.adn.adnalquilerparqueadero.infraestructura.db.AppDatabase
import com.adn.adnalquilerparqueadero.infraestructura.repositorio.AlquilerRepositorio
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.DetalleVehiculoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.MotoViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.MotosListViewModelFactory
import com.adn.adnalquilerparqueadero.infraestructura.viewModel.factory.ResumentViewModelFactory

object InjectorUtils {

    private fun getAlquilerRepository(context: Context): AlquilerRepositorio {
        return AlquilerRepositorio.getInstance(
                AppDatabase.getInstance(context.applicationContext).alquilerDao())
    }

    fun provideAlquilerListViewModelFactory(context: Context): MotosListViewModelFactory {
        val repository = getAlquilerRepository(context)
        return MotosListViewModelFactory(
            repository
        )
    }

    fun provideMotoAlquilerViewModelFactory(context: Context): MotoViewModelFactory {
        val repository = getAlquilerRepository(context)
        return MotoViewModelFactory(
            repository
        )
    }

    fun provideResumenAlquilerViewModelFactory(context: Context): ResumentViewModelFactory {
        val repository = getAlquilerRepository(context)
        return ResumentViewModelFactory(
            repository
        )
    }

    fun provideDetalleAlquilerViewModelFactory(context: Context,id:Int): DetalleVehiculoViewModelFactory {
        val repository = getAlquilerRepository(context)
        return DetalleVehiculoViewModelFactory(
            repository,
            id
        )
    }

}
