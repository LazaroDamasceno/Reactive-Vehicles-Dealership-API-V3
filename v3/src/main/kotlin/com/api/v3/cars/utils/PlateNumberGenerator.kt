package com.api.v3.cars.utils

class PlateNumberGenerator {

    companion object {
        private val letters = ('A'..'Z').toList()
        private val numbers = ('0'..'9').toList()

        fun generate(): String {
            val randomFormat = if (Math.random() < 0.5) "LLNNNLL" else "NLLNNNLL"
            val plateNumber = StringBuilder()

            for (char in randomFormat) {
                when (char) {
                    'L' -> plateNumber.append(letters.random())
                    'N' -> plateNumber.append(numbers.random())
                }
            }

            return plateNumber.toString()
        }
    }

}