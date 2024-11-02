package com.api.v3.cars.services

import com.api.v3.cars.domain.subclasses.*
import com.api.v3.cars.domain.superclass.CarRepository
import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.cars.utils.CarResponseMapper
import com.api.v3.vehicles.dtos.VehicleRegistrationDto
import com.api.v3.vehicles.services.VehicleRegistrationService
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CarRegistrationServiceImpl: CarRegistrationService {

    @Autowired
    private lateinit var carRepository: CarRepository

    @Autowired
    private lateinit var vehicleRegistrationService: VehicleRegistrationService

    override suspend fun registerSedan(requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val savedVehicle = vehicleRegistrationService.register(requestDto)
            val car = Sedan.of(savedVehicle)
            val savedCar = carRepository.save(car)
            CarResponseMapper.map(savedCar)
        }
    }

    override suspend fun registerSUV(requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val savedVehicle = vehicleRegistrationService.register(requestDto)
            val car = SUV.of(savedVehicle)
            val savedCar = carRepository.save(car)
            CarResponseMapper.map(savedCar)
        }
    }

    override suspend fun registerCrossover(requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val savedVehicle = vehicleRegistrationService.register(requestDto)
            val car = Crossover.of(savedVehicle)
            val savedCar = carRepository.save(car)
            CarResponseMapper.map(savedCar)
        }
    }

    override suspend fun registerElectric(requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val savedVehicle = vehicleRegistrationService.register(requestDto)
            val car = Electric.of(savedVehicle)
            val savedCar = carRepository.save(car)
            CarResponseMapper.map(savedCar)
        }
    }

    override suspend fun registerHybrid(requestDto: @Valid VehicleRegistrationDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val savedVehicle = vehicleRegistrationService.register(requestDto)
            val car = Hybrid.of(savedVehicle)
            val savedCar = carRepository.save(car)
            CarResponseMapper.map(savedCar)
        }
    }

}