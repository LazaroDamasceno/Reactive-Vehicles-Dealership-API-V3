package com.api.v3.employees.controllers

import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.employees.services.EmployeeModificationService
import com.api.v3.employees.services.EmployeeRegistrationService
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v3/employees")
class EmployeeController : EmployeeModificationService {

    @Autowired
    private lateinit var registrationService: EmployeeRegistrationService

    private lateinit var modificationService: EmployeeModificationService

    @PostMapping("salesperson")
    suspend fun registerSalesperson(@RequestBody requestDto: @Valid PersonRegistrationRequestDto) {
        return registrationService.registerSalesperson(requestDto)
    }

    @PutMapping("{employeeId}")
    override suspend fun modify(
        @PathVariable employeeId: String,
        @RequestBody requestDto: @Valid PersonModificationRequestDto
    ): EmployeeResponseDto {
        return modificationService.modify(employeeId, requestDto)
    }

}