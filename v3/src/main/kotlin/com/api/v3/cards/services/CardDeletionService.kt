package com.api.v3.cards.services

interface CardDeletionService {

    suspend fun deletion(cardNumber: String)

}