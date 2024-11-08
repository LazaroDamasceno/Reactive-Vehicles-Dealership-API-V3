package com.api.v3.cars.services

import com.api.v3.cards.dtos.CardResponseDto
import com.api.v3.cars.domain.superclass.CarRepository
import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.cars.utils.CarResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CarRetrievalServiceImpl: CarRetrievalService {

    @Autowired
    private lateinit var carRepository: CarRepository

    override suspend fun findAll(): Flow<CarResponseDto> {
        return withContext(Dispatchers.IO) {
            carRepository.findAll().map { e -> CarResponseMapper.map(e) }
        }
    }

}