package com.api.v3.employees.services

import com.api.v3.persons.dtos.PersonRegistrationRequestDto

interface EmployeeRegistrationService {

    suspend fun registerSalesperson(requestDto: PersonRegistrationRequestDto)

}