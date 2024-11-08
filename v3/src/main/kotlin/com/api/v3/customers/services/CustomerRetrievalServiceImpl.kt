package com.api.v3.customers.services

import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.utils.CustomerResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CustomerRetrievalServiceImpl: CustomerRetrievalService {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    override suspend fun findAll(): Flow<CustomerResponseDto> {
        return withContext(Dispatchers.IO) {
            customerRepository.findAll().map { e -> CustomerResponseMapper.map(e) }
        }
    }

}