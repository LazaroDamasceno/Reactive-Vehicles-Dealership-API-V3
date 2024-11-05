package com.api.v3.cards

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardDeletionTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun testSuccessfulDeletion1() {
        webTestClient
            .delete()
            .uri("api/v3/cards/9950427275954341")
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulDeletion1() {
        webTestClient
            .delete()
            .uri("api/v3/cards/9950427275954341")
            .exchange()
            .expectStatus().is5xxServerError()
    }

    @Test
    fun testSuccessfulDeletion2() {
        webTestClient
            .delete()
            .uri("api/v3/cards/7597375365339377")
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulDeletion2() {
        webTestClient
            .delete()
            .uri("api/v3/cards/7597375365339377")
            .exchange()
            .expectStatus().is5xxServerError()
    }

}