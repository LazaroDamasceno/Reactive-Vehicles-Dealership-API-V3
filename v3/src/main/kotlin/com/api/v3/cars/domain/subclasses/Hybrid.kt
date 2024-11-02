package com.api.v3.cars.domain.subclasses

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.vehicles.domain.Vehicle

class Hybrid(vehicle: Vehicle): Car(vehicle, "Hybrid") {

    companion object {
        fun of(vehicle: Vehicle): Hybrid {
            return Hybrid(vehicle)
        }
    }

}