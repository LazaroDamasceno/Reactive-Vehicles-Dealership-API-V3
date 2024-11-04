package com.api.v3.cars.services

import com.api.v3.cars.domain.superclass.Car

interface CarSellingService {

    suspend fun markASold(car: Car): Car

}