package com.api.v3.employees.services

import com.api.v3.employees.domain.subclasses.Salesperson
import com.api.v3.employees.domain.superclass.EmployeeRepository
import com.api.v3.employees.utils.EmployeeResponseMapper
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import com.api.v3.persons.services.PersonRegistrationService
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeRegistrationServiceImpl: EmployeeRegistrationService {

    @Autowired
    private lateinit var personRegistrationService: PersonRegistrationService

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    override suspend fun registerSalesperson(requestDto: @Valid PersonRegistrationRequestDto) {
        return withContext(Dispatchers.IO) {
            val savedPerson = personRegistrationService.register(requestDto)
            val employee = Salesperson.of(savedPerson)
            val savedEmployee = employeeRepository.save(employee)
            EmployeeResponseMapper.map(savedEmployee)
        }
    }

}