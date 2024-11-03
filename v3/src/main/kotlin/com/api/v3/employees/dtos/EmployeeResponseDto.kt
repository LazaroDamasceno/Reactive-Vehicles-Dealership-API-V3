package com.api.v3.employees.dtos

import com.api.v3.persons.dtos.PersonResponseDto

data class EmployeeResponseDto(
    val employeeId: String,
    val job: String,
    val personResponseDto: PersonResponseDto
)
