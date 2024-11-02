package com.api.v3.cars.domain

import com.api.v3.cars.dtos.CarRegistrationRequestDto

class SUV: Car {

    private constructor(
        price: Double,
        manufacturingYear: Int,
        model: String,
        make: String
    ) : super(
        "SUV",
        price,
        manufacturingYear,
        model,
        make
    )

    companion object {
        fun of(requestDto: CarRegistrationRequestDto): SUV {
            return SUV(
                requestDto.price,
                requestDto.manufacturingYear,
                requestDto.model,
                requestDto.make
            )
        }
    }

}