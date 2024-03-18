package com.github.tacascer.springsecurityinaction.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello() = "Hello!"

    @GetMapping("/ciao")
    fun ciao() = "Ciao!"
}