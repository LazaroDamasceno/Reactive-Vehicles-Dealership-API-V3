package com.api.v3.cards.domain.superclass

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CardRepository: CoroutineCrudRepository<Card, UUID>