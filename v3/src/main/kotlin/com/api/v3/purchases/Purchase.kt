package com.api.v3.purchases

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.customers.domain.Customer
import com.api.v3.employees.domain.superclass.Employee
import com.api.v3.utils.Constants
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

data class Purchase(
    @Id var id: UUID,
    var customer: Customer,
    var salesperson: Employee,
    var car: Car,
    var finalPrice: Double,
    var createdAt: LocalDateTime,
    var createdAtZone: ZoneId
) {

    companion object {
        fun of(customer: Customer, salesperson: Employee, car: Car): Purchase {
            return Purchase(
                UUID.randomUUID(),
                customer,
                salesperson,
                car,
                car.vehicle.price * (1 + Constants.salesTax),
                LocalDateTime.now(),
                ZoneId.systemDefault()
            )
        }
    }

}
