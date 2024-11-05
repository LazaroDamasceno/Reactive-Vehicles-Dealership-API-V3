package com.api.v3.cards

import com.api.v3.cards.dtos.CardOwnerDataDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.Test

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CreditCardRegistrationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    val requestDto = CardOwnerDataDto(
        "John Doe",
        "123456789"
    )

    @Test
    fun testRegistration() {
        webTestClient
            .post()
            .uri("api/v3/cards/credit-card")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

}