package com.api.v3.cars.domain

import com.api.v3.cars.dtos.CarRegistrationRequestDto

class Hybrid: Car {

    private constructor(
        price: Double,
        manufacturingYear: Int,
        model: String,
        make: String
    ) : super(
        "Hybrid",
        price,
        manufacturingYear,
        model,
        make
    )

    companion object {
        fun of(requestDto: CarRegistrationRequestDto): Hybrid {
            return Hybrid(
                requestDto.price,
                requestDto.manufacturingYear,
                requestDto.model,
                requestDto.make
            )
        }
    }

}