package com.api.v3.payments.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PaymentRepository: CoroutineCrudRepository<Payment, UUID>