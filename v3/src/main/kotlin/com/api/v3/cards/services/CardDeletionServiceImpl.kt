package com.api.v3.cards.services

import com.api.v3.cards.domain.superclass.CardRepository
import com.api.v3.cards.utils.CardFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CardDeletionServiceImpl: CardDeletionService {

    @Autowired
    private lateinit var cardFinderUtil: CardFinderUtil

    @Autowired
    private lateinit var cardRepository: CardRepository

    override suspend fun deletion(cardNumber: String) {
        return withContext(Dispatchers.IO) {
            val card = cardFinderUtil.find(cardNumber)
            cardRepository.delete(card)
        }
    }

}