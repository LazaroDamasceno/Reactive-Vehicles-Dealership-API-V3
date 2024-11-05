package com.api.v3.payments

import com.api.v3.cards.dtos.CardResponseDto
import java.math.BigInteger
import java.time.ZonedDateTime

data class PaymentResponseDto(
    var orderNumber: BigInteger,
    var cardResponseDto: CardResponseDto,
    var createdAt: ZonedDateTime
)
