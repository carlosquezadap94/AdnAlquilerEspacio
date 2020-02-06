package com.adn.adnalquilerparqueadero.views

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.adn.adnalquilerparqueadero.PageObject
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.presentacion.actividades.MainActivity
import org.junit.Before
import org.junit.Ignore
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


    @Ignore
    @Test
    fun agregarVehiculo() {
        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        pageObject!!.sleep(1)
        pageObject!!.escribirEdit(R.id.editext_placa, "ASD123")
        pageObject!!.escribirEdit(R.id.editext_cc, "500")
        pageObject!!.sleep(1)
        pageObject!!.clickBoton(R.id.button_agregar)
        pageObject!!.sleep(1)
        pageObject!!.matchToast(R.string.registro_agregado)

        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        pageObject!!.sleep(1)
        pageObject!!.escribirEdit(R.id.editext_placa, "ASD123")
        pageObject!!.escribirEdit(R.id.editext_cc, "500")
        pageObject!!.sleep(1)
        pageObject!!.clickBoton(R.id.button_agregar)
        pageObject!!.sleep(1)
        pageObject!!.matchToast(R.string.vehiculo_ya_registrado)
    }
    @Ignore
    @Test
    fun placaMala() {
        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        pageObject!!.sleep(1)
        pageObject!!.escribirEdit(R.id.editext_placa, "ASD12E")
        pageObject!!.escribirEdit(R.id.editext_cc, "500")
        pageObject!!.sleep(1)
        pageObject!!.clickBoton(R.id.button_agregar)
        pageObject!!.sleep(1)
        pageObject!!.matchToast(R.string.placa_invalida_auto)
    }

    @Ignore
    @Test
    fun EspacioVacio() {
        onView(withId(R.id.viewPager)).perform(ViewActions.swipeLeft())
        pageObject!!.clickBoton(R.id.button_agregar)
        pageObject!!.sleep(1)
        pageObject!!.matchToast(R.string.ingresar_correctos)
    }


}