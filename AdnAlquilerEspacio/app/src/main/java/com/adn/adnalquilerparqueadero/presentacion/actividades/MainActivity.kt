package com.adn.adnalquilerparqueadero.presentacion.actividades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.ActivityMainBinding
import com.adn.adnalquilerparqueadero.dominio.repositorio.IAlquilerRepositorio
import javax.inject.Inject

class MainActivity : AppCompatActivity()
{



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }
}
