package com.api.v3.purchases.services

import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto

interface PurchaseRegistrationService {

    suspend fun register(requestDto: PurchaseRegistrationRequestDto)

}