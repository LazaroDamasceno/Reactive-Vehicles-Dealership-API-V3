package com.api.v3.cars

import com.api.v3.vehicles.dtos.VehicleResponseDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class AllCarsRegistrationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    val requestDto = VehicleResponseDto(
        "Acadia",
        "GMC",
        20_000.0,
        2024
    )

    @Test
    fun testSuccessfulRegistration1() {
        webTestClient
            .post()
            .uri("api/v3/cars/crossover")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testSuccessfulRegistration2() {
        webTestClient
            .post()
            .uri("api/v3/cars/electric")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testSuccessfulRegistration3() {
        webTestClient
            .post()
            .uri("api/v3/cars/electric")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testSuccessfulRegistration4() {
        webTestClient
            .post()
            .uri("api/v3/cars/sedan")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testSuccessfulRegistration5() {
        webTestClient
            .post()
            .uri("api/v3/cars/suv")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

}