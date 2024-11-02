package com.api.v3.cars.utils

import com.api.v3.cars.domain.Car
import com.api.v3.cars.dtos.CarResponseDto

class CarResponseMapper {

    companion object {
        fun map(car: Car): CarResponseDto {
            return CarResponseDto(
                car.make,
                car.model,
                car.manufacturingYear,
                car.price,
                car.type,
                car.vin,
                car.plateNumber
            )
        }
    }

}