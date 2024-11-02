package com.api.v3.cars.domain

import com.api.v3.vehicles.domain.Vehicle

class SUV(vehicle: Vehicle): Car(vehicle, "SUV") {

    companion object {
        fun of(vehicle: Vehicle): SUV {
            return SUV(vehicle)
        }
    }

}