package com.api.v3.employees.controllers

import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.employees.services.EmployeeModificationService
import com.api.v3.employees.services.EmployeeRegistrationService
import com.api.v3.employees.services.EmployeeRetrievalService
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v3/employees")
class EmployeeController {

    @Autowired
    private lateinit var registrationService: EmployeeRegistrationService

    @Autowired
    private lateinit var modificationService: EmployeeModificationService

    @Autowired
    private lateinit var employeeRetrievalService: EmployeeRetrievalService

    @PostMapping("salesperson")
    suspend fun registerSalesperson(@RequestBody requestDto: @Valid PersonRegistrationRequestDto) {
        return registrationService.registerSalesperson(requestDto)
    }

    @PutMapping("{employeeId}")
    suspend fun modify(
        @PathVariable employeeId: String,
        @RequestBody requestDto: @Valid PersonModificationRequestDto
    ): EmployeeResponseDto {
        return modificationService.modify(employeeId, requestDto)
    }

    @GetMapping
    suspend fun findAll(): Flow<EmployeeResponseDto> {
        return employeeRetrievalService.findAll()
    }

}