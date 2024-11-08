package com.api.v3.cards.services

import com.api.v3.cards.dtos.CardResponseDto
import kotlinx.coroutines.flow.Flow

interface CardRetrievalService {

    suspend fun findAll(): Flow<CardResponseDto>

}