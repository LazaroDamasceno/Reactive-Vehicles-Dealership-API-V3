package com.api.v3.cars.dtos

data class CarResponseDto(
    var make: String,
    var model: String,
    var manufacturingYear: Int,
    var price: Double,
    var type: String,
    var vin: String,
    var plateNumber: String
)
