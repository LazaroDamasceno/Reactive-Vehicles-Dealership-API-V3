package com.api.v3.cars.services

import com.api.v3.cars.domain.superclass.CarRepository
import com.api.v3.vehicles.dtos.VehicleResponseDto
import org.springframework.beans.factory.annotation.Autowired

abstract class CarRegistrationService {

    @Autowired
    protected lateinit var carRepository: CarRepository

    abstract suspend fun register(requestDto: VehicleResponseDto)

}