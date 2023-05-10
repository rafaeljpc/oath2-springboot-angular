package io.github.rafaeljpc.oauth2.study.controller

import io.github.rafaeljpc.oauth2.study.AuthApp
import io.github.rafaeljpc.oauth2.study.AuthAppTestConfig
import io.github.rafaeljpc.oauth2.study.ClientConfig
import mu.KotlinLogging
import org.junit.jupiter.api.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import kotlin.test.Test
import kotlin.test.assertEquals

private val log = KotlinLogging.logger { }

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [AuthAppTestConfig::class, AuthApp::class, WebTestClient::class]
)
@EnableConfigurationProperties(ClientConfig::class)
@ActiveProfiles("test")
class UserControllerITest @Autowired constructor(
    private val webTestClient: WebTestClient,
    private val clientConfig: ClientConfig,
) {

    @Test
    @Order(1)
    fun `should say hello`() {
        // Given
        val helloReturnType = object : ParameterizedTypeReference<Map<String, String>>() {}

        val token = getToken(clientConfig, webTestClient)

        // When
        val helloResponse = webTestClient.get().uri("/user/hello")
            .header("Authorization", "Bearer $token")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
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
        val helloReturnType = object : ParameterizedTypeReference<Map<String, String>>() {}

        // When
        val helloResponse = webTestClient.get().uri("/user/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().is4xxClientError
        // Then
    }

    companion object {

        @JvmStatic
        val tokenReturnType = object : ParameterizedTypeReference<Map<String, String>>() {}

        fun getToken(clientConfig: ClientConfig, webTestClient: WebTestClient) =
            webTestClient.post().uri(clientConfig.tokenUrl)
                .body(
                    BodyInserters.fromFormData("grant_type", clientConfig.grantType)
                        .with("client_id", clientConfig.clientId)
                        .with("client_secret", clientConfig.clientSecret)
                        .with("audience", clientConfig.audience)
                )
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful.expectBody(tokenReturnType)
                .returnResult().responseBody?.get("access_token") ?: error("token invalid")
    }
}