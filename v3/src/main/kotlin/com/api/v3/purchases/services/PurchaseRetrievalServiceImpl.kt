package com.api.v3.purchases.services

import com.api.v3.purchases.domain.PurchaseRepository
import com.api.v3.purchases.dtos.PurchaseResponseDto
import com.api.v3.purchases.utils.PurchaseResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PurchaseRetrievalServiceImpl: PurchaseRetrievalService {

    @Autowired
    private lateinit var purchaseRepository: PurchaseRepository

    override suspend fun findAll(): Flow<PurchaseResponseDto> {
        return withContext(Dispatchers.IO) {
            purchaseRepository.findAll().map { e -> PurchaseResponseMapper.map(e) }
        }
    }

}