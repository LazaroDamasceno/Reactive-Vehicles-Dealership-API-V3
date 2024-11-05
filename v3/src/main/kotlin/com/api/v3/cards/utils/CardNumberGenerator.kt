package com.api.v3.cards.utils

import java.util.*

class CardNumberGenerator {

    companion object {

        private val random = Random()

        fun generate(): String {
            val digits = 16
            val builder = StringBuilder()
            for (i in 1..digits) {
                builder.append(random.nextInt(10))
            }
            return builder.toString()
        }
    }

}