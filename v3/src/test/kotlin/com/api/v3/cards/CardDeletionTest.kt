package com.api.v3.cards

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardDeletionTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulDeletion1() {
        webTestClient
            .delete()
            .uri("api/v3/cards/0243723997710800")
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulDeletion1() {
        webTestClient
            .delete()
            .uri("api/v3/cards/0243723997710800")
            .exchange()
            .expectStatus().is5xxServerError()
    }

    @Test
    @Order(3)
    fun testSuccessfulDeletion2() {
        webTestClient
            .delete()
            .uri("api/v3/cards/6579320614964825")
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Order(4)
    @Test
    fun testUnsuccessfulDeletion2() {
        webTestClient
            .delete()
            .uri("api/v3/cards/6579320614964825")
            .exchange()
            .expectStatus().is5xxServerError()
    }

}