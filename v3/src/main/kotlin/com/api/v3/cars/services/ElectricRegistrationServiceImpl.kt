package com.api.v3.cars.services

import com.api.v3.cars.domain.Electric
import com.api.v3.cars.dtos.CarRegistrationRequestDto
import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.cars.utils.CarResponseMapper
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class ElectricRegistrationServiceImpl: CarRegistrationService() {

    override suspend fun register(requestDto: @Valid CarRegistrationRequestDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val electric = Electric.of(requestDto)
            val savedElectric = carRepository.save(electric)
            CarResponseMapper.map(savedElectric)
        }
    }

}