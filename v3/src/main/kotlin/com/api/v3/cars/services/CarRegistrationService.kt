package com.api.v3.cars.services

import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.vehicles.dtos.VehicleRegistrationDto

interface CarRegistrationService {

    suspend fun registerSedan(requestDto: VehicleRegistrationDto): CarResponseDto
    suspend fun registerSUV(requestDto: VehicleRegistrationDto): CarResponseDto
    suspend fun registerCrossover(requestDto: VehicleRegistrationDto): CarResponseDto
    suspend fun registerElectric(requestDto: VehicleRegistrationDto): CarResponseDto
    suspend fun registerHybrid(requestDto: VehicleRegistrationDto): CarResponseDto

}