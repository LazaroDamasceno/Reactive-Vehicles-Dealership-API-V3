package com.api.v3.employees.utils

import com.api.v3.employees.domain.superclass.Employee
import com.api.v3.employees.domain.superclass.EmployeeRepository
import com.api.v3.employees.exceptions.EmployeeNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EmployeeFinderUtil {

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    suspend fun find(employeeId: String): Employee {
        return withContext(Dispatchers.IO) {
            val existingEmployee = employeeRepository
                .findAll()
                .filter { e -> e.employeeId == employeeId }
                .singleOrNull()
            if (existingEmployee == null) {
                throw EmployeeNotFoundException()
            }
            existingEmployee
        }
    }

}