package com.api.v3.employees.services

import com.api.v3.employees.domain.superclass.EmployeeRepository
import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.employees.utils.EmployeeResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class EmployeeRetrievalServiceImpl: EmployeeRetrievalService {

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    override suspend fun findAll(): Flow<EmployeeResponseDto> {
        return withContext(Dispatchers.IO) {
            employeeRepository.findAll().map { e -> EmployeeResponseMapper.map(e) }
        }
    }

}