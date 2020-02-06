package com.adn.adnalquilerparqueadero.views

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.adn.adnalquilerparqueadero.ObjectUtils
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.presentacion.actividades.MainActivity
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test


class AgregarAlquilerTest {


    private var objectUtils: ObjectUtils? = null

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun iniciarPageObject() {
        objectUtils = ObjectUtils()
    }



    @Test
    fun agregarVehiculo() {
        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        objectUtils!!.sleep(1)
        objectUtils!!.escribirEditext(R.id.editext_placa, "ASD123")
        objectUtils!!.escribirEditext(R.id.editext_cc, "500")
        objectUtils!!.sleep(1)
        objectUtils!!.clickBoton(R.id.button_agregar)
        objectUtils!!.sleep(1)
        objectUtils!!.matchToast(R.string.registro_agregado)

        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        objectUtils!!.sleep(1)
        objectUtils!!.escribirEditext(R.id.editext_placa, "ASD123")
        objectUtils!!.escribirEditext(R.id.editext_cc, "500")
        objectUtils!!.sleep(1)
        objectUtils!!.clickBoton(R.id.button_agregar)
        objectUtils!!.sleep(1)
        objectUtils!!.matchToast(R.string.vehiculo_ya_registrado)
    }

    @Test
    fun placaMala() {
        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        objectUtils!!.sleep(1)
        objectUtils!!.escribirEditext(R.id.editext_placa, "ASD12E")
        objectUtils!!.escribirEditext(R.id.editext_cc, "500")
        objectUtils!!.sleep(1)
        objectUtils!!.clickBoton(R.id.button_agregar)
        objectUtils!!.sleep(1)
        objectUtils!!.matchToast(R.string.placa_invalida_auto)
    }


    @Test
    fun EspacioVacio() {
        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        objectUtils!!.clickBoton(R.id.button_agregar)
        objectUtils!!.sleep(1)
        objectUtils!!.matchToast(R.string.ingresar_correctos)
    }


}