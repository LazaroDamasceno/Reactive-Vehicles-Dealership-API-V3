package com.api.v3.purchases.services

import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto
import com.api.v3.purchases.dtos.PurchaseResponseDto

interface PurchaseRegistrationService {

    suspend fun register(requestDto: PurchaseRegistrationRequestDto): PurchaseResponseDto

}