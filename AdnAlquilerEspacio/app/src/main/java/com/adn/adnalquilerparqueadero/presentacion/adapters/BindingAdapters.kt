package com.adn.adnalquilerparqueadero.presentacion.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.AUTOMOVIL
import com.adn.adnalquilerparqueadero.dominio.servicios.crear.MOTOCICLETA
import com.squareup.picasso.Picasso


val VEHICULO_ICONO = mapOf(AUTOMOVIL to R.drawable.ic_directions_car_black_24dp,
                            MOTOCICLETA to R.drawable.ic_motorcycle_black_24dp)


@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("imageUrl")
fun selectIcon(view: ImageView, tipoV: String) {
    for ((key, value) in VEHICULO_ICONO)
    {
        if (key.equals(tipoV))
        {
            Picasso.get().load("www.fgoas.co").error(value).into(view)
        }
    }
}


@BindingAdapter("insertText")
fun insertText(view: TextView, float: Float) {
    view.text = float.toString()
}




