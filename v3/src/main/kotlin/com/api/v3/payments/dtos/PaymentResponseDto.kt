package com.api.v3.payments.dtos

import com.api.v3.cards.dtos.CardResponseDto
import java.time.ZonedDateTime

data class PaymentResponseDto(
    var orderNumber: String,
    var cardResponseDto: CardResponseDto,
    var createdAt: ZonedDateTime
)
