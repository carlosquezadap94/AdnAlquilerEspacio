package com.adn.adnalquilerparqueadero

import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun test_validarPlacaCarro()
    {
        var pattern = Pattern.compile("^[a-zA-Z]{3}[0-9]{3}\$")
        var m = pattern.matcher("ABC123")
        assertEquals(true,m.matches())
    }

    @Test
    fun test_validarPlacaMoto()
    {
        var pattern = Pattern.compile("^[a-zA-Z]{3}[0-9]{2}[a-zA-Z]\$")
        var m = pattern.matcher("ABC12E")
        assertEquals(true,m.matches())
    }
}
