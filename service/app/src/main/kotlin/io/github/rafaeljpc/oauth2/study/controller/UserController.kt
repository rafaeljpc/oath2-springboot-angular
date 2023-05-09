package io.github.rafaeljpc.oauth2.study.controller

import io.github.rafaeljpc.oauth2.study.repository.UserRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/user")
class UserController(
    val userRepository: UserRepository
) {

    @GetMapping(path = [""], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listAll() = userRepository.findAll()

    @GetMapping(path = ["/hello"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hello() = mapOf(Pair("message", "hello buddy!!!!"))
}