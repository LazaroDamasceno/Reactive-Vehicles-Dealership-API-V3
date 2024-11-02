package com.api.v3.cars.dtos

import com.api.v3.vehicles.dtos.VehicleResponseDto

data class CarResponseDto(
    val type: String,
    val vehicleResponseDto: VehicleResponseDto,
    val plateNumber: String,
    val vin: String
)
