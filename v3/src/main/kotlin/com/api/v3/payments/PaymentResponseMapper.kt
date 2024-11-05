package com.api.v3.payments

import com.api.v3.cards.utils.CardResponseMapper
import com.api.v3.payments.domain.Payment
import java.time.ZonedDateTime

class PaymentResponseMapper {

    companion object {
        fun map(payment: Payment): PaymentResponseDto {
            return PaymentResponseDto(
                payment.orderNumber,
                CardResponseMapper.map(payment.card),
                ZonedDateTime.of(payment.createdAt, payment.createdAtZone)
            )
        }
    }

}