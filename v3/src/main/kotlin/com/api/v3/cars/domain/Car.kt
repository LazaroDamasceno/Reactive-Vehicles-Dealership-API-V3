package com.api.v3.cars.domain

import com.api.v3.cars.utils.PlateNumberGenerator
import com.api.v3.cars.utils.VinGenerator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
open class Car {

    @Id
    var id: UUID = UUID.randomUUID()
    var make: String
    var model: String
    var manufacturingYear: Int
    var price: Double
    var type: String
    var vin: String = VinGenerator.generate()
    var plateNumber: String = PlateNumberGenerator.generate()
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    internal constructor(type: String, price: Double, manufacturingYear: Int, model: String, make: String) {
        this.type = type
        this.price = price
        this.manufacturingYear = manufacturingYear
        this.model = model
        this.make = make
    }

}