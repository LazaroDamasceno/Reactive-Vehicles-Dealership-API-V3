package com.api.v3.cars.domain.subclasses

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.vehicles.domain.Vehicle

class Crossover(vehicle: Vehicle): Car(vehicle, "Crossover") {

    companion object {
        fun of(vehicle: Vehicle): Crossover {
            return Crossover(vehicle)
        }
    }

}