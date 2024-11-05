package com.api.v3.cards.services

import com.api.v3.cards.dtos.CardOwnerDataDto

interface CardRegistrationService {

    suspend fun registerCreditCard(requestDto: CardOwnerDataDto)
    suspend fun registerDebitCard(requestDto: CardOwnerDataDto)

}