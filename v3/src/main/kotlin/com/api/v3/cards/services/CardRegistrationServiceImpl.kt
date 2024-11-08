package com.api.v3.cards.services

import com.api.v3.cards.domain.subclasses.CreditCard
import com.api.v3.cards.domain.subclasses.DebitCard
import com.api.v3.cards.domain.superclass.CardRepository
import com.api.v3.cards.dtos.CardOwnerDataDto
import com.api.v3.cards.dtos.CardResponseDto
import com.api.v3.cards.utils.CardResponseMapper
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CardRegistrationServiceImpl: CardRegistrationService {

    @Autowired
    private lateinit var cardRepository: CardRepository

    override suspend fun registerCreditCard(requestDto: @Valid CardOwnerDataDto): CardResponseDto {
        return withContext(Dispatchers.IO) {
            val card = CreditCard.of(requestDto)
            val savedCard = cardRepository.save(card)
            CardResponseMapper.map(savedCard)
        }
    }

    override suspend fun registerDebitCard(requestDto: @Valid CardOwnerDataDto): CardResponseDto {
        return withContext(Dispatchers.IO) {
            val card = DebitCard.of(requestDto)
            val savedCard = cardRepository.save(card)
            CardResponseMapper.map(savedCard)
        }
    }

}