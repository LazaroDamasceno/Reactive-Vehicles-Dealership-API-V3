package com.api.v3.employees.domain.superclass

import com.api.v3.employees.utils.EmployeeIdGenerator
import com.api.v3.persons.domain.Person
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
open class Employee {

    @Id
    var id: UUID = UUID.randomUUID()
    var employeeId: String = EmployeeIdGenerator.generate()
    var job: String
    var person: Person
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    protected constructor(job: String, person: Person) {
        this.person = person
        this.job = job
    }
}