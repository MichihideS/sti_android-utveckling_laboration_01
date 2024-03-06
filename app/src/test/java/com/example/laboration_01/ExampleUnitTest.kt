package com.example.laboration_01

import org.junit.Test

import org.junit.Assert.*
import java.util.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun gacha(){
        var threeStar = 0
        var fourStar = 0
        var fiveStar = 0

        for (i in 1..10) {
            val randomNumber = (1..1000).random()
            when (randomNumber) {
                in 1..6 -> fiveStar++
                in 7..58 -> fourStar++
                else -> threeStar++
            }
        }

        println("You got $threeStar 3* rolls, $fourStar 4* rolls and $fiveStar 5* rolls")
    }
}