package com.api.v3.cars.domain

import com.api.v3.cars.dtos.CarRegistrationRequestDto

class Electric: Car {

    private constructor(
        price: Double,
        manufacturingYear: Int,
        model: String,
        make: String
    ) : super(
        "Electric",
        price,
        manufacturingYear,
        model,
        make
    )

    companion object {
        fun of(requestDto: CarRegistrationRequestDto): Electric {
            return Electric(
                requestDto.price,
                requestDto.manufacturingYear,
                requestDto.model,
                requestDto.make
            )
        }
    }

}