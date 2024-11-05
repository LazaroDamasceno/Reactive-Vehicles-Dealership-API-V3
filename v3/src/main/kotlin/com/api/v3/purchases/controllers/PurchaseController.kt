package com.api.v3.purchases.controllers

import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto
import com.api.v3.purchases.dtos.PurchaseResponseDto
import com.api.v3.purchases.services.PurchaseRegistrationService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v3/purchases")
class PurchaseController {

    @Autowired
    private lateinit var registrationService: PurchaseRegistrationService

    @PostMapping
    suspend fun register(@RequestBody requestDto: @Valid PurchaseRegistrationRequestDto): PurchaseResponseDto {
        return registrationService.register(requestDto)
    }

}