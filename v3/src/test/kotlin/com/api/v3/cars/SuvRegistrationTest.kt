package com.api.v3.cars

import com.api.v3.vehicles.dtos.VehicleResponseDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class SuvRegistrationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    val requestDto = VehicleResponseDto(
        "Acadia",
        "GMC",
        20_000.0,
        2024
    )

    @Test
    fun testSuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/cars/suv")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

}