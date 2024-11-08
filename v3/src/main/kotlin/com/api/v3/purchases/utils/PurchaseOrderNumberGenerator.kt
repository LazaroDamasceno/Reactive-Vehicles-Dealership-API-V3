package com.api.v3.purchases.utils

import java.math.BigInteger
import java.time.LocalDateTime

class PurchaseOrderNumberGenerator {

    companion object {

        private val year = LocalDateTime.now().year
        private val month = LocalDateTime.now().monthValue
        private val day = LocalDateTime.now().dayOfMonth
        private val hour = LocalDateTime.now().hour
        private val minute = LocalDateTime.now().minute
        private val second = LocalDateTime.now().second
        private val text = "${year}${month}${day}0${hour}${minute}${second}00000000"
        private var biText = BigInteger(text)

        fun generate(): String {
            biText = biText.add(BigInteger.ONE)
            return biText.toString()
        }

    }

}