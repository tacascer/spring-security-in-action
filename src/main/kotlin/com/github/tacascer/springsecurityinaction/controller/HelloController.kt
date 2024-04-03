package com.github.tacascer.springsecurityinaction.controller

import com.github.tacascer.springsecurityinaction.entities.Otp
import com.github.tacascer.springsecurityinaction.entities.User
import com.github.tacascer.springsecurityinaction.service.UserService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class AuthController(private val userService: UserService) {

    @PostMapping("/user/add")
    fun addUser(@RequestBody user: User) {
        userService.addUser(user)
    }

    @PostMapping("/user/auth")
    fun auth(@RequestBody user: User) {
        userService.auth(user)
    }

    @PostMapping("/otp/check")
    fun check(@RequestBody otp: Otp): ResponseEntity<Void> {
        return if (userService.check(otp)) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }
}