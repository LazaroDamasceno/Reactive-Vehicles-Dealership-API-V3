package com.api.v3.cards.controllers

import com.api.v3.cards.dtos.CardOwnerDataDto
import com.api.v3.cards.services.CardDeletionService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.api.v3.cards.services.CardRegistrationService as CardRegistrationService1

@RestController
@RequestMapping("api/v3/cards")
class CardController {

    @Autowired
    private lateinit var registrationService: CardRegistrationService1

    @Autowired
    private lateinit var deletionService: CardDeletionService

    @PostMapping("credit-card")
    suspend fun registerCreditCard(@RequestBody requestDto: @Valid CardOwnerDataDto) {
        return registrationService.registerCreditCard(requestDto)
    }

    @PostMapping("debit-card")
    suspend fun registerDebitCard(@RequestBody requestDto: @Valid CardOwnerDataDto) {
        return registrationService.registerDebitCard(requestDto)
    }

    @DeleteMapping("{cardNumber}")
    suspend fun deletion(@PathVariable cardNumber: String) {
        return deletionService.deletion(cardNumber)
    }

}
