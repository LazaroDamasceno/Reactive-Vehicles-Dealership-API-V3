package com.api.v3.purchases.controllers

import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto
import com.api.v3.purchases.dtos.PurchaseResponseDto
import com.api.v3.purchases.services.PurchaseRegistrationService
import com.api.v3.purchases.services.PurchaseRetrievalService
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v3/purchases")
class PurchaseController {

    @Autowired
    private lateinit var registrationService: PurchaseRegistrationService

    @Autowired
    private lateinit var purchaseRetrievalService: PurchaseRetrievalService

    @PostMapping
    suspend fun register(@RequestBody requestDto: @Valid PurchaseRegistrationRequestDto): PurchaseResponseDto {
        return registrationService.register(requestDto)
    }

    @GetMapping
    suspend fun findAll(): Flow<PurchaseResponseDto> {
        return purchaseRetrievalService.findAll()
    }

}