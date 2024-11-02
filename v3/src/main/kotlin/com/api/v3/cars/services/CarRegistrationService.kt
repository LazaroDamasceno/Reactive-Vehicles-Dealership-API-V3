package com.api.v3.cars.services

import com.api.v3.cars.dtos.CarRegistrationRequestDto

interface CarRegistrationService<T> {

    suspend fun register(requestDto: CarRegistrationRequestDto): T

}