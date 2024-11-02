package com.api.v3.cars

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Car {

    @Id
    var id: UUID = UUID.randomUUID()
    var make: String
    var model: String
    var manufacturingYear: Int
    var price: Double
    var vin: String = VinGenerator.generate()
    var plateNumber: String = PlateNumberGenerator.generate()
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    private constructor(make: String, model: String, manufacturingYear: Int, price: Double) {
        this.make = make
        this.model = model
        this.manufacturingYear = manufacturingYear
        this.price = price
    }

    companion object {
        fun of(requestDto: CarRegistrationRequestDto): Car {
            return Car(
                requestDto.make,
                requestDto.model,
                requestDto.manufacturingYear,
                requestDto.price
            )
        }
    }

}