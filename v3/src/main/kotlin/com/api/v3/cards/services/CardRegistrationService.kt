package com.api.v3.cards.services

import com.api.v3.cards.dtos.CardOwnerDataDto
import com.api.v3.cards.dtos.CardResponseDto

interface CardRegistrationService {

    suspend fun registerCreditCard(requestDto: CardOwnerDataDto): CardResponseDto
    suspend fun registerDebitCard(requestDto: CardOwnerDataDto): CardResponseDto

}