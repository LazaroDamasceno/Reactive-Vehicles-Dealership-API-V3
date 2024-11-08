package com.api.v3.purchases.domain

import com.api.v3.cars.domain.superclass.Car
import com.api.v3.customers.domain.Customer
import com.api.v3.employees.domain.superclass.Employee
import com.api.v3.payments.domain.Payment
import com.api.v3.purchases.utils.PurchaseOrderNumberGenerator
import com.api.v3.utils.Constants
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

data class Purchase(
    @Id var id: UUID,
    var orderNumber: String,
    var customer: Customer,
    var salesperson: Employee,
    var car: Car,
    var discount: Double,
    var finalPrice: Double,
    var payment: Payment,
    var createdAt: LocalDateTime,
    var createdAtZone: ZoneId
) {

    companion object {
        fun of(
            customer: Customer,
            salesperson: Employee,
            car: Car,
            discount: Double,
            payment: Payment
        ): Purchase {
            return Purchase(
                UUID.randomUUID(),
                PurchaseOrderNumberGenerator.generate(),
                customer,
                salesperson,
                car,
                discount,
                ((car.vehicle.price * (1 - discount)) * (1 + Constants.salesTax)),
                payment,
                LocalDateTime.now(),
                ZoneId.systemDefault()
            )
        }
    }

}
