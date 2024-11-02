package com.api.v3.cars

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CarRepository: CoroutineCrudRepository<Car, UUID>