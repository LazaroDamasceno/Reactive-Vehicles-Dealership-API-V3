package com.api.v3.purchases.services

import com.api.v3.cards.utils.CardFinderUtil
import com.api.v3.cars.exceptions.UnavailableCarException
import com.api.v3.cars.services.CarSellingService
import com.api.v3.cars.utils.CarFinderUtil
import com.api.v3.customers.utils.CustomerFinderUtil
import com.api.v3.employees.utils.EmployeeFinderUtil
import com.api.v3.payments.services.PaymentRegistrationService
import com.api.v3.purchases.domain.Purchase
import com.api.v3.purchases.domain.PurchaseRepository
import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto
import com.api.v3.purchases.dtos.PurchaseResponseDto
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
    private lateinit var carSellingService: CarSellingService

    @Autowired
    private lateinit var purchaseRepository: PurchaseRepository

    @Autowired
    private lateinit var paymentRegistrationService: PaymentRegistrationService

    @Autowired
    private lateinit var cardFinderUtil: CardFinderUtil

    override suspend fun register(requestDto: @Valid PurchaseRegistrationRequestDto): PurchaseResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(requestDto.ssn)
            val salesperson = employeeFinderUtil.find(requestDto.employeeId)
            val car = carFinderUtil.find(requestDto.vin)
            if (car.soldAt != null) throw UnavailableCarException()
            val soldCar = carSellingService.markASold(car)
            val card = cardFinderUtil.find(requestDto.cardNumber)
            val payment = paymentRegistrationService.register(soldCar, card)
            val purchase = Purchase.of(customer, salesperson, soldCar, requestDto.discount, payment)
            val savedPurchase = purchaseRepository.save(purchase)
            PurchaseResponseMapper.map(savedPurchase)
        }
    }

}