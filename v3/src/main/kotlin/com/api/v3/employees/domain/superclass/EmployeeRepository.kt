package com.api.v3.employees.domain.superclass

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface EmployeeRepository: CoroutineCrudRepository<Employee, UUID>