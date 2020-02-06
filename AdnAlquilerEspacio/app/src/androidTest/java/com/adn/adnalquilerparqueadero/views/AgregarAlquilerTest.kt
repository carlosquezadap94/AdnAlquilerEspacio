package com.adn.adnalquilerparqueadero.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.adn.adnalquilerparqueadero.PageObject
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.presentacion.actividades.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AgregarAlquilerTest {


    private var pageObject: PageObject? = null

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun iniciarPageObject() {
        pageObject = PageObject()
    }


    @Test
    fun agregarVehiculo()
    {
        Espresso.onView(ViewMatchers.withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        pageObject!!.sleep(1)
        pageObject!!.escribirEdit(R.id.editext_placa, "ASD123")
        pageObject!!.escribirEdit(R.id.editext_cc, "500")
        pageObject!!.sleep(1)
        pageObject!!.clickBoton(R.id.button_agregar)
        pageObject!!.sleep(1)
        pageObject!!.matchToast(R.string.registro_agregado)
    }


    @Test
    fun agregarVehiculoRepetido()
    {
        Espresso.onView(ViewMatchers.withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        pageObject!!.sleep(1)
        pageObject!!.escribirEdit(R.id.editext_placa, "ASD123")
        pageObject!!.escribirEdit(R.id.editext_cc, "500")
        pageObject!!.sleep(1)
        pageObject!!.clickBoton(R.id.button_agregar)
        pageObject!!.sleep(1)
        pageObject!!.matchToast(R.string.vehiculo_ya_registrado)
    }


}