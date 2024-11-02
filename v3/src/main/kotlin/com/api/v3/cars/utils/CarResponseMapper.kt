package com.api.v3.cars.utils

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.vehicles.utils.VehicleResponseMapper

class CarResponseMapper {
    companion object {
        fun map(car: Car): CarResponseDto {
            return CarResponseDto(
                car.type,
                VehicleResponseMapper.map(car.vehicle),
                car.plateNumber,
                car.vin
            )
        }
    }
}