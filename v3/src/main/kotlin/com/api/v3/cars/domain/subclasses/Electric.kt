package com.api.v3.cars.domain.subclasses

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.vehicles.domain.Vehicle

class Electric(vehicle: Vehicle): Car(vehicle, "Electric") {

    companion object {
        fun of(vehicle: Vehicle): Electric {
            return Electric(vehicle)
        }
    }

}