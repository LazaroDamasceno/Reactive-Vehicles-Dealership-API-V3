package com.api.v3.employees.utils

import com.api.v3.employees.domain.superclass.Employee
import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.persons.utils.PersonResponseMapper

class EmployeeResponseMapper {

    companion object {
        fun map(employee: Employee): EmployeeResponseDto {
            return EmployeeResponseDto(
                employee.employeeId,
                employee.job,
                PersonResponseMapper.map(employee.person)
            )
        }
    }

}