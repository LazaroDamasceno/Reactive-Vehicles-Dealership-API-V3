package com.api.v3.cars.domain.subclasses

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.vehicles.domain.Vehicle

class Sedan(vehicle: Vehicle): Car(vehicle, "Sedan") {

    companion object {
        fun of(vehicle: Vehicle): Sedan {
            return Sedan(vehicle)
        }
    }

}