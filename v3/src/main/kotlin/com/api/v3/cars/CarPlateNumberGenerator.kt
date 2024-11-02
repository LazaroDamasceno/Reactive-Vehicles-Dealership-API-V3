package com.api.v3.cars

class CarPlateNumberGenerator {

    companion object {
        private val letters = ('A'..'Z').toList()
        private val numbers = ('0'..'9').toList()

        fun generate(): String {
            val firstPart = (1..3).map { letters.random() }.joinToString("")
            val secondPart = (1..3).map { numbers.random() }.joinToString("")
            return "${firstPart}${secondPart}"
        }
    }

}