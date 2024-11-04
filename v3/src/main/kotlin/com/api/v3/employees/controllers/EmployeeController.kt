package com.api.v3.employees.controllers

import com.api.v3.employees.services.EmployeeRegistrationService
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v3/employees")
class EmployeeController {

    @Autowired
    private lateinit var registrationService: EmployeeRegistrationService

    @PostMapping("salesperson")
    suspend fun registerSalesperson(@RequestBody requestDto: @Valid PersonRegistrationRequestDto) {
        return registrationService.registerSalesperson(requestDto)
    }

}