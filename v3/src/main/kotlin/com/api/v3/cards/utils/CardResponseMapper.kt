package com.api.v3.cards.utils

import com.api.v3.cards.domain.superclass.Card
import com.api.v3.cards.dtos.CardResponseDto

class CardResponseMapper {

    companion object {
        fun map(card: Card): CardResponseDto {
            return CardResponseDto(
                card.type,
                card.ownerName,
                card.ownerSsn,
                card.number
            )
        }
    }

}