package com.api.v3.cars.domain

import com.api.v3.cars.dtos.CarRegistrationRequestDto

class Crossover: Car {

    private constructor(
        price: Double,
        manufacturingYear: Int,
        model: String,
        make: String
    ) : super(
        "Crossover",
        price,
        manufacturingYear,
        model,
        make
    )

    companion object {
        fun of(requestDto: CarRegistrationRequestDto): Crossover {
            return Crossover(
                requestDto.price,
                requestDto.manufacturingYear,
                requestDto.model,
                requestDto.make
            )
        }
    }

}