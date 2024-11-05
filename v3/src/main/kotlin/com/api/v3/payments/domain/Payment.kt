package com.api.v3.payments.domain

import com.api.v3.cards.domain.superclass.Card
import com.api.v3.cars.domain.superclass.Car
import com.api.v3.payments.PaymentOrderNumberGenerator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
data class Payment(
    @Id var id: UUID,
    var orderNumber: BigInteger,
    var car: Car,
    var card: Card,
    var createdAt: LocalDateTime,
    var createdAtZone: ZoneId
) {

    companion object {
        fun of(car: Car, card: Card): Payment {
            return Payment(
                UUID.randomUUID(),
                PaymentOrderNumberGenerator.generate(),
                car,
                card,
                LocalDateTime.now(),
                ZoneId.systemDefault()
            )
        }
    }

}