package com.api.v3.cars.dtos

import jakarta.validation.constraints.NotBlank

data class CarRegistrationRequestDto(
    var make: @NotBlank String,
    var model: @NotBlank String,
    var manufacturingYear: Int,
    var price: Double
)
