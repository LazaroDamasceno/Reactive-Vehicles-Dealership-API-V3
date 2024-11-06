package com.api.v3.purchases

import com.api.v3.purchases.dtos.PurchaseRegistrationRequestDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class PurchaseRegistrationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    val requestDto = PurchaseRegistrationRequestDto(
        "123456789",
        "",
        "",
        0.2,
        ""
    )

    @Test
    fun testSuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/purchases")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/purchases")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is5xxServerError()
    }

}