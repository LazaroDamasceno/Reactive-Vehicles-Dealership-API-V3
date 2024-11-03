package com.api.v3.employees.domain.subclasses

import com.api.v3.employees.domain.superclass.Employee
import com.api.v3.persons.domain.Person

class Salesperson(person: Person): Employee("Salesperson", person)