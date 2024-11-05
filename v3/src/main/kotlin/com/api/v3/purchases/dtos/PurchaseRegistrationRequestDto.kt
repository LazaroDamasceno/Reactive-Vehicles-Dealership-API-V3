package com.api.v3.purchases.dtos

data class PurchaseRegistrationRequestDto(
    val ssn: String,
    val employeeId: String,
    val vin: String,
    val discount: Double,
    val cardNumber: String
)
