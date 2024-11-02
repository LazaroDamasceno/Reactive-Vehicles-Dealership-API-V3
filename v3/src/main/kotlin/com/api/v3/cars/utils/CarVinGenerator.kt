package com.api.v3.cars.utils

class CarVinGenerator {

    companion object {
        private val characters = ('A'..'Z').toList() + ('0'..'9').toList()

        fun generateVIN(): String {
            return (1..17).map { characters.random() }.joinToString("")
        }
    }

}