package com.api.v3.purchases.dtos

import com.api.v3.cars.dtos.CarResponseDto
import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.employees.dtos.EmployeeResponseDto
import com.api.v3.payments.dtos.PaymentResponseDto
import java.time.ZonedDateTime

data class PurchaseResponseDto(
    val orderNumber: String,
    val customerResponseDto: CustomerResponseDto,
    val salespersonResponseDto: EmployeeResponseDto,
    val carResponseDto: CarResponseDto,
    val discount: Double,
    val finalPrice: Double,
    val paymentResponseDto: PaymentResponseDto,
    val createdAt: ZonedDateTime
)
