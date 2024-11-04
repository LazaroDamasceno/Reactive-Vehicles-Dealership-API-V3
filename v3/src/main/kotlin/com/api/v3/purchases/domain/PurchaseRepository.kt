package com.api.v3.purchases.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PurchaseRepository: CoroutineCrudRepository<Purchase, UUID>