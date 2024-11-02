package com.api.v3.cars.services

import com.api.v3.cars.domain.CarRepository
import com.api.v3.cars.dtos.CarRegistrationRequestDto
import com.api.v3.cars.dtos.CarResponseDto
import org.springframework.beans.factory.annotation.Autowired

abstract class CarRegistrationService {

    @Autowired
    protected lateinit var carRepository: CarRepository

    protected abstract suspend fun register(requestDto: CarRegistrationRequestDto): CarResponseDto

}