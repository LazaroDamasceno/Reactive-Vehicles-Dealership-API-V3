package com.api.v3.vehicles.services

import com.api.v3.vehicles.domain.Vehicle
import com.api.v3.vehicles.dtos.VehicleRegistrationDto

interface VehicleRegistrationService {

    suspend fun register(requestDto: VehicleRegistrationDto): Vehicle

}