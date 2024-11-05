package com.api.v3.payments.utils

import java.math.BigInteger
import java.time.LocalDateTime

class PaymentOrderNumberGenerator {

    companion object {

        private val year = LocalDateTime.now().year
        private val month = LocalDateTime.now().month
        private val day = LocalDateTime.now().dayOfMonth
        private val hour = LocalDateTime.now().hour
        private val minute = LocalDateTime.now().minute
        private val second = LocalDateTime.now().second
        private val text = "$year$month$day-$hour$minute$second-0000000"
        private var biText = BigInteger(text)

        fun generate(): BigInteger {
            biText = biText.add(BigInteger.ONE)
            return biText
        }

    }

}