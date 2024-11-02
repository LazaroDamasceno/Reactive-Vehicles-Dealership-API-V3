package com.api.v3.vehicles.dtos

data class VehicleRegistrationDto(
    val model: String,
    val make: String,
    var price: Double,
    var manufacturingYear: Int
)
