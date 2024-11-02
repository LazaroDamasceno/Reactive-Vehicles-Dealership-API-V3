package com.api.v3.cars.controllers

import com.api.v3.cars.dtos.CarRegistrationRequestDto
import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.cars.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v3/cars")
class CarController {

    @Autowired
    private lateinit var crossoverRegistrationService: CrossoverRegistrationServiceImpl

    @Autowired
    private lateinit var electricRegistrationService: ElectricRegistrationServiceImpl

    @Autowired
    private lateinit var hybridRegistrationService: HybridRegistrationServiceImpl

    @Autowired
    private lateinit var sedanRegistrationService: SedanRegistrationServiceImpl

    @Autowired
    private lateinit var suvRegistrationService: SuvRegistrationServiceImpl

    @PostMapping("crossover")
    suspend fun registerCrossover(@RequestBody requestDto: CarRegistrationRequestDto): CarResponseDto {
        return crossoverRegistrationService.register(requestDto)
    }

    @PostMapping("electric")
    suspend fun registerElectric(@RequestBody requestDto: CarRegistrationRequestDto): CarResponseDto {
        return electricRegistrationService.register(requestDto)
    }

    @PostMapping("hybrid")
    suspend fun registerHybrid(@RequestBody requestDto: CarRegistrationRequestDto): CarResponseDto {
        return hybridRegistrationService.register(requestDto)
    }

    @PostMapping("sedan")
    suspend fun registerSedan(@RequestBody requestDto: CarRegistrationRequestDto): CarResponseDto {
        return sedanRegistrationService.register(requestDto)
    }

    @PostMapping("suv")
    suspend fun registerSUV(@RequestBody requestDto: CarRegistrationRequestDto): CarResponseDto {
        return suvRegistrationService.register(requestDto)
    }

}
