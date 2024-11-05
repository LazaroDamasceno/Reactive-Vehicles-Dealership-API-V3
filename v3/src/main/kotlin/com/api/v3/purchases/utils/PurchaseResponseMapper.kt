package com.api.v3.purchases.utils

import com.api.v3.cars.utils.CarResponseMapper
import com.api.v3.customers.utils.CustomerResponseMapper
import com.api.v3.employees.utils.EmployeeResponseMapper
import com.api.v3.payments.utils.PaymentResponseMapper
import com.api.v3.purchases.domain.Purchase
import com.api.v3.purchases.dtos.PurchaseResponseDto
import java.time.ZonedDateTime

class PurchaseResponseMapper {

    companion object {
        fun map(purchase: Purchase): PurchaseResponseDto {
            return PurchaseResponseDto(
                purchase.orderNumber,
                CustomerResponseMapper.map(purchase.customer),
                EmployeeResponseMapper.map(purchase.salesperson),
                CarResponseMapper.map(purchase.car),
                (purchase.discount * 100.0),
                purchase.finalPrice,
                PaymentResponseMapper.map(purchase.payment),
                ZonedDateTime.of(purchase.createdAt, purchase.createdAtZone)
            )
        }
    }

}