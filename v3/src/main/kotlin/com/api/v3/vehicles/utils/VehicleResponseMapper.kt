package com.api.v3.vehicles.utils

import com.api.v3.vehicles.dtos.VehicleResponseDto
import com.api.v3.vehicles.domain.Vehicle

class VehicleResponseMapper {

    companion object {
        fun map(vehicle: Vehicle): VehicleResponseDto {
            return VehicleResponseDto(
                vehicle.model,
                vehicle.make,
                vehicle.price,
                vehicle.manufacturingYear
            )
        }
    }

}