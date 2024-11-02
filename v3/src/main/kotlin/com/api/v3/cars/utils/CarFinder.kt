package com.api.v3.cars.utils

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.cars.domain.superclass.CarRepository
import com.api.v3.cars.exceptions.CarNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CarFinder {

    @Autowired
    private lateinit var carRepository: CarRepository

    suspend fun find(vin: String): Car {
        return withContext(Dispatchers.IO) {
            val existingCar = carRepository
                .findAll()
                .filter { e -> e.vin  == vin }
                .singleOrNull()
            if (existingCar == null) {
                throw CarNotFoundException()
            }
            existingCar
        }
    }

}