package com.api.v3.purchases.services

import com.api.v3.cars.utils.CarFinderUtil
import com.api.v3.customers.utils.CustomerFinderUtil
import com.api.v3.employees.utils.EmployeeFinderUtil
import com.api.v3.purchases.domain.Purchase
import com.api.v3.purchases.domain.PurchaseRepository
import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto
import com.api.v3.purchases.utils.PurchaseResponseMapper
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class PurchaseRegistrationServiceImpl: PurchaseRegistrationService {

    @Autowired
    private lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    private lateinit var employeeFinderUtil: EmployeeFinderUtil

    @Autowired
    private lateinit var carFinderUtil: CarFinderUtil

    @Autowired
    private lateinit var purchaseRepository: PurchaseRepository

    override suspend fun register(requestDto: @Valid PurchaseRegistrationRequestDto) {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(requestDto.ssn)
            val salesperson = employeeFinderUtil.find(requestDto.employeeId)
            val car = carFinderUtil.find(requestDto.vin)
            val purchase = Purchase.of(customer, salesperson, car, requestDto.discount)
            val savedPurchase = purchaseRepository.save(purchase)
            PurchaseResponseMapper.map(savedPurchase)
        }
    }

}