package com.adn.adnalquilerparqueadero.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.rule.ActivityTestRule
import com.adn.adnalquilerparqueadero.PageObject
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.presentacion.actividades.MainActivity
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class ListarAlquileresTest {

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
    fun listarVehiculo() {
        //RecyclerView visible
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_vehiculo))
            .check(ViewAssertions.matches(isDisplayed()))

        //Texto no vehiculos visible
        Espresso.onView(ViewMatchers.withId(R.id.ll_no_vehiculos))
            .check(ViewAssertions.matches
                (ViewMatchers.withEffectiveVisibility
                (ViewMatchers.Visibility.GONE)))
    }

}