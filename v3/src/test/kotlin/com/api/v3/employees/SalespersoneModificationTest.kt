package com.api.v3.employees

import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class SalespersonModificationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    var requestDto = PersonModificationRequestDto(
        "Gabriel",
        "Silva",
        "Varzea Jr.",
        "jr@gvarzea.com",
        LocalDate.parse("2000-12-12"),
        "St. Dennis, Paris, France",
        "male",
        "1234567890"
    )

    @Test
    fun testSuccessfulRegistration() {
        val employeeId = ""
        webTestClient
            .put()
            .uri("api/v3/employees/employeeId")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRegistration() {
        val employeeId = ""
        webTestClient
            .put()
            .uri("api/v3/employees/employeeId")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is5xxServerError()
    }

}