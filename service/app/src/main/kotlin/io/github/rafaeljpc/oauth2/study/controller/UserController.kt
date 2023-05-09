package io.github.rafaeljpc.oauth2.study.controller

import io.github.rafaeljpc.oauth2.study.repository.UserRepository
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("user-controller")
@RequestMapping(path = ["/user"])
@CrossOrigin(origins = ["*"])
class UserController(
    private val userRepository: UserRepository
) {

    @GetMapping(path = [""], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listAll() = userRepository.findAll().toList()

    @GetMapping(path = ["/hello"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hello() = ResponseEntity.ok().body(mapOf(Pair("message", "hello buddy!!!!")))
}