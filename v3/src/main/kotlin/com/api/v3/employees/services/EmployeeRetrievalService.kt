package com.api.v3.employees.services

import com.api.v3.employees.dtos.EmployeeResponseDto
import kotlinx.coroutines.flow.Flow

interface EmployeeRetrievalService {

    suspend fun findAll(): Flow<EmployeeResponseDto>

}