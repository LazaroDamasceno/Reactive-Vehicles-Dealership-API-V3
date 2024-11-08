package com.api.v3.cards.services

import com.api.v3.cards.domain.superclass.CardRepository
import com.api.v3.cards.dtos.CardResponseDto
import com.api.v3.cards.utils.CardResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CardRetrievalServiceImpl: CardRetrievalService {

    @Autowired
    private lateinit var cardRepository: CardRepository

    override suspend fun findAll(): Flow<CardResponseDto> {
        return withContext(Dispatchers.IO) {
            cardRepository.findAll().map { e -> CardResponseMapper.map(e) }
        }
    }

}