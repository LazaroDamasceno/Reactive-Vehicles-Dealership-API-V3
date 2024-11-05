package com.api.v3.employees.services

import com.api.v3.employees.domain.superclass.EmployeeRepository
import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.employees.utils.EmployeeFinderUtil
import com.api.v3.employees.utils.EmployeeResponseMapper
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.services.PersonModificationService
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class EmployeeModificationServiceImpl: EmployeeModificationService {

    @Autowired
    private lateinit var personModificationService: PersonModificationService

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    @Autowired
    private lateinit var employeeFinderUtil: EmployeeFinderUtil

    override suspend fun modify(
        employeeId: String,
        requestDto: @Valid PersonModificationRequestDto
    ): EmployeeResponseDto {
        return withContext(Dispatchers.IO) {
            val employee = employeeFinderUtil.find(employeeId)
            val modifiedPerson = personModificationService.modify(employee.person, requestDto)
            employee.person = modifiedPerson
            val modifiedEmployee = employeeRepository.save(employee)
            EmployeeResponseMapper.map(modifiedEmployee)
        }
    }

}