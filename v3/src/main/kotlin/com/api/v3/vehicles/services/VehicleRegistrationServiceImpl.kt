package com.api.v3.vehicles.services

import com.api.v3.vehicles.domain.Vehicle
import com.api.v3.vehicles.domain.VehicleRepository
import com.api.v3.vehicles.dtos.VehicleRegistrationDto
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class VehicleRegistrationServiceImpl: VehicleRegistrationService {

    @Autowired
    private lateinit var vehicleRepository: VehicleRepository

    override suspend fun register(requestDto: @Valid VehicleRegistrationDto): Vehicle {
        return withContext(Dispatchers.IO) {
            val existingVehicle = vehicleRepository
                .findAll()
                .filter { v -> v.make ==  requestDto.make
                        && v.model == requestDto.model
                        && v.manufacturingYear == requestDto.manufacturingYear
                }
                .singleOrNull()
            if (existingVehicle != null) {
                return@withContext existingVehicle
            }
            val vehicle = Vehicle.of(requestDto)
            vehicleRepository.save(vehicle)
        }
    }

}