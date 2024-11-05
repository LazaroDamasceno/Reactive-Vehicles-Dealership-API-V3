package com.api.v3.payments.services

import com.api.v3.cards.domain.superclass.Card
import com.api.v3.cars.domain.superclass.Car
import com.api.v3.payments.domain.Payment

interface PaymentRegistrationService {

    suspend fun register(car: Car, card: Card): Payment

}