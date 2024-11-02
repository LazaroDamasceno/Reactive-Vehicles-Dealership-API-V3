package com.api.v3.cars.utils

class VinGenerator {

    companion object {
        private val characters = ('A'..'Z').toList() + ('0'..'9').toList()

        fun generate(): String {
            val randomVIN = StringBuilder()
            for (i in 1..17) {
                val randomIndex = characters.indices.random()
                randomVIN.append(characters[randomIndex])
            }
            return randomVIN.toString()
        }
    }

}