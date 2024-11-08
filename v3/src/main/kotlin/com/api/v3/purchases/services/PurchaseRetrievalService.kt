package com.api.v3.purchases.services

import com.api.v3.purchases.dtos.PurchaseResponseDto
import kotlinx.coroutines.flow.Flow

interface PurchaseRetrievalService {

    suspend fun findAll(): Flow<PurchaseResponseDto>

}