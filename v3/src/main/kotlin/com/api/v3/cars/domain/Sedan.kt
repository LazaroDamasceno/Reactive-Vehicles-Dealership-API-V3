package com.api.v3.cars.domain

import com.api.v3.cars.dtos.CarRegistrationRequestDto

class Sedan: Car {

    private constructor(
        price: Double,
        manufacturingYear: Int,
        model: String,
        make: String
    ) : super(
        "Sedan",
        price,
        manufacturingYear,
        model,
        make
    )

    companion object {
        fun of(requestDto: CarRegistrationRequestDto): Sedan {
            return Sedan(
                requestDto.price,
                requestDto.manufacturingYear,
                requestDto.model,
                requestDto.make
            )
        }
    }

}