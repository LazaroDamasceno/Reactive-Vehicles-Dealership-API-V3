package com.api.v3.employees

import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class SalespersonRegistrationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    var requestDto = PersonRegistrationRequestDto(
        "Gabriel",
        "",
        "Varzea",
        "987654321",
        "gvarzea@mail.com",
        LocalDate.parse("2000-12-12"),
        "St. Dennis, Paris",
        "male",
        "1234567890"
    )

    @Test
    fun testSuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/employees/salesperson")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/employees/salesperson")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is5xxServerError()
    }

}