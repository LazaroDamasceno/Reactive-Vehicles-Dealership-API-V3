package com.api.v3.cars.services

import com.api.v3.cars.dtos.CarResponseDto
import kotlinx.coroutines.flow.Flow

interface CarRetrievalService {

    suspend fun findAll(): Flow<CarResponseDto>

}