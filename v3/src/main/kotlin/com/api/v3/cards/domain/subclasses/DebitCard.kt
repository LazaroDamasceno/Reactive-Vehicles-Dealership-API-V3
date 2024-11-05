package com.api.v3.cards.domain.subclasses

import com.api.v3.cards.dtos.CardOwnerDataDto
import com.api.v3.cards.domain.superclass.Card

class DebitCard(ownerName: String, ownerSsn: String): Card("Debit card", ownerName, ownerSsn) {

    companion object {
        fun of(requestDto: CardOwnerDataDto): DebitCard {
            return DebitCard(requestDto.ownerName, requestDto.ownerSsn)
        }
    }

}