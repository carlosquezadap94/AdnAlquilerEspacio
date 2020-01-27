package com.adn.adnalquilerparqueadero.presentacion.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }
}
