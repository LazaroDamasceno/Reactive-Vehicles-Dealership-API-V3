package com.api.v3.vehicles.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface VehicleRepository: CoroutineCrudRepository<Vehicle, UUID>