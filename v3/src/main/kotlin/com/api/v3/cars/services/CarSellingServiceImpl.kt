package com.api.v3.cars.services

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.cars.domain.superclass.CarRepository
import com.api.v3.cars.exceptions.UnavailableCarException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CarSellingServiceImpl: CarSellingService {

    @Autowired
    private lateinit var carRepository: CarRepository

    override suspend fun markASold(car: Car): Car {
        return withContext(Dispatchers.IO) {
            if (car.soldAt != null) {
                throw UnavailableCarException()
            }
            car.markAsSold()
            carRepository.save(car)
        }
    }

}