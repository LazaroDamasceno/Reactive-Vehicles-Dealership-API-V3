package com.api.v3.employees.services

import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.persons.dtos.PersonModificationRequestDto

interface EmployeeModificationService {

    suspend fun modify(employeeId: String, requestDto: PersonModificationRequestDto): EmployeeResponseDto

}