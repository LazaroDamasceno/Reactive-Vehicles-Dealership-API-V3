package com.api.v3.payments.services

import com.api.v3.cards.domain.superclass.Card
import com.api.v3.cars.domain.superclass.Car
import com.api.v3.payments.domain.Payment
import com.api.v3.payments.domain.PaymentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class PaymentRegistrationServiceImpl: PaymentRegistrationService {

    @Autowired
    private lateinit var paymentRepository: PaymentRepository

    override suspend fun register(car: Car, card: Card): Payment {
        return withContext(Dispatchers.IO) {
            val payment = Payment.of(car, card)
            paymentRepository.save(payment)
        }
    }

}