package com.api.v3.cards.utils

import com.api.v3.cards.exceptions.CardNotFoundException
import com.api.v3.cards.domain.superclass.Card
import com.api.v3.cards.domain.superclass.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CardFinderUtil {

    @Autowired
    private lateinit var cardRepository: CardRepository

    suspend fun find(cardNumber: String): Card {
        return withContext(Dispatchers.IO) {
            val existingCard = cardRepository
                .findAll()
                .filter { c -> c.number == cardNumber }
                .singleOrNull()
            if (existingCard == null) {
                throw CardNotFoundException()
            }
            existingCard
        }
    }

}