package com.api.v3.cars.controllers

import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.cars.services.CarRegistrationService
import com.api.v3.vehicles.dtos.VehicleRegistrationDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v3/cars")
class CarController {
    
    @Autowired
    private lateinit var registrationService: CarRegistrationService

    @PostMapping("sedan")
    suspend fun registerSedan(@RequestBody requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return registrationService.registerSedan(requestDto)
    }

    @PostMapping("suv")
    suspend fun registerSUV(@RequestBody requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return registrationService.registerSUV(requestDto)
    }

    @PostMapping("crossover")
    suspend fun registerCrossover(@RequestBody requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return registrationService.registerCrossover(requestDto)
    }

    @PostMapping("electric")
    suspend fun registerElectric(@RequestBody requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return registrationService.registerElectric(requestDto)
    }

    @PostMapping("hybrid")
    suspend fun registerHybrid(@RequestBody requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return registrationService.registerHybrid(requestDto)
    }

}