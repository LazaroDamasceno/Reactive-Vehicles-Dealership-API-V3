package com.api.v3.vehicles.domain

import com.api.v3.vehicles.dtos.VehicleRegistrationDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Document
class Vehicle {

    @Id
    var id: UUID = UUID.randomUUID()
    var model: String
    var make: String
    var price = 0.0
    var manufacturingYear = 0
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    private constructor(model: String, make: String, price: Double, manufacturingYear: Int) {
        this.model = model
        this.make = make
        this.price = price
        this.manufacturingYear = manufacturingYear
    }

    companion object {
        fun of(requestDto: VehicleRegistrationDto): Vehicle {
            return Vehicle(
                requestDto.model,
                requestDto.make,
                requestDto.price,
                requestDto.manufacturingYear
            )
        }
    }

}