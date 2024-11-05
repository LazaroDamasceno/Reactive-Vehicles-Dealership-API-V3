package com.api.v3.cards.domain.subclasses

import com.api.v3.cards.dtos.CardOwnerDataDto
import com.api.v3.cards.domain.superclass.Card

class CreditCard(ownerName: String, ownerSsn: String): Card("Credit card", ownerName, ownerSsn) {

        companion object {
            fun of(requestDto: CardOwnerDataDto): CreditCard {
                return CreditCard(requestDto.ownerName, requestDto.ownerSsn)
            }
        }

}