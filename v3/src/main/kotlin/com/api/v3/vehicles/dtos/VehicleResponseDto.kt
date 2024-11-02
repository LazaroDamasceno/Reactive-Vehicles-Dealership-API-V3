package com.api.v3.vehicles.dtos

data class VehicleResponseDto(
    val model: String,
    val make: String,
    val price: Double,
    val manufacturingYear: Int
)
