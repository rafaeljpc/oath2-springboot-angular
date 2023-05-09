package io.github.rafaeljpc.oauth2.study.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


@Configuration
@EnableWebSecurity
class AuthAppConfig(
    @Value("\${auth0.audience}")
    private val audience: String,
    @Value("\${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private val issuer: String,
) {

    companion object {

        @JvmStatic
        private val SWAGGER_PATHS =
            arrayOf("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/webjars/swagger-ui/**")
    }


    @Bean
    fun objectMapper(): Jackson2ObjectMapperBuilder {
        val builder = Jackson2ObjectMapperBuilder()
        builder
            .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .serializationInclusion(JsonInclude.Include.NON_NULL)

        return builder
    }


    @Bean
    fun filterChain(http: HttpSecurity) = http
        .authorizeHttpRequests { authorize ->
            authorize
                .requestMatchers(*SWAGGER_PATHS).anonymous()
                .anyRequest().hasAuthority("SCOPE_read:user")
                .and().cors()
                .and().oauth2ResourceServer().jwt()
        }
        .build()

}