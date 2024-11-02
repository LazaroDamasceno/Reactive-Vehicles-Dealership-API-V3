package com.api.v3.cars

import com.api.v3.vehicles.domain.Vehicle
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Car {

    @Id
    var id: UUID = UUID.randomUUID()
    var vehicle: Vehicle
    var type: String
    var vin: String = CarVinGenerator.generateVIN()
    var plateNumber: String = CarPlateNumberGenerator.generate()
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    constructor(vehicle: Vehicle, type: String) {
        this.vehicle = vehicle
        this.type = type
    }

}