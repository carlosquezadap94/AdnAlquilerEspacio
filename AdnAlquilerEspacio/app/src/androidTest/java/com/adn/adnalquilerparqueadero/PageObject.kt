package com.adn.adnalquilerparqueadero

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.matcher.ViewMatchers

class PageObject {
    @Throws(InterruptedException::class)
    fun sleep(segundos: Int) {
        Thread.sleep(segundos * 1000.toLong())
    }

    fun navegarMenu(idActivity: Int, idFragment: Int) {
        Espresso.onView(ViewMatchers.withId(idActivity))
            .perform(NavigationViewActions.navigateTo(idFragment))
    }

    fun escribirEdit(id: Int, texto: String?) {
        val editText = Espresso.onView(ViewMatchers.withId(id))
        editText.perform(ViewActions.replaceText(texto))
    }

    fun clickBoton(idBoton: Int) {
        Espresso.onView(ViewMatchers.withId(idBoton)).perform(ViewActions.click())
    }

    fun matchToast(idMensaje: Int) {
        Espresso.onView(ViewMatchers.withText(idMensaje)).inRoot(ToastMatcher())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun matchEdit(idEdit: Int, mensaje: String?) {
        Espresso.onView(ViewMatchers.withId(idEdit))
            .check(ViewAssertions.matches(ViewMatchers.withText(mensaje)))
    }
}