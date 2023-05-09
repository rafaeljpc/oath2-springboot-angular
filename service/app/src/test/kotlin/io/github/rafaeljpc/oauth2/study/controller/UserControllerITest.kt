package io.github.rafaeljpc.oauth2.study.controller

import io.github.rafaeljpc.oauth2.study.AuthApp
import io.github.rafaeljpc.oauth2.study.AuthAppTestConfig
import org.junit.jupiter.api.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [AuthAppTestConfig::class, AuthApp::class, WebTestClient::class]
)
class UserControllerITest @Autowired constructor(
    private val webTestClient: WebTestClient,
) {

    @Test
    @Order(1)
    fun `should say hello`() {
        // Given
        val helloReturnType = object : ParameterizedTypeReference<Map<String, String>>() {}

        // When
        val helloResponse = webTestClient.get().uri("/user/hello").accept(MediaType.APPLICATION_JSON).exchange()
            .expectStatus().is2xxSuccessful.expectBody(helloReturnType).returnResult().responseBody
            ?: error("UNEXPECTED")

        // Then
        assertEquals(helloResponse.size, 1)
        assertEquals(helloResponse["message"], "hello buddy!!!!")
    }

    @Test
    @Order(2)
    fun `should not say hello access error`() {
        // Given
        // When
        // Then
    }
}