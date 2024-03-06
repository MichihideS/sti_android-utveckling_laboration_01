package com.example.laboration_01

class Gacha {
    fun randomNumber(): String {
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

        return("Here are your draw results!\nNumber of 3* pulls: $threeStar\nNumber of 4* pulls:" +
                " $fourStar\nNumber of 5* pulls: $fiveStar\nBetter luck next time!")
    }
}