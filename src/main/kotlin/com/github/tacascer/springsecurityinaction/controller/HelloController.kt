package com.github.tacascer.springsecurityinaction.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

private val logger = KotlinLogging.logger {}

@Controller
class HelloController {
    @GetMapping("/")
    fun main(): String {
        return "main.html"
    }

    @PostMapping("/test")
    @ResponseBody
    @CrossOrigin("http://localhost:8080")
    fun test(): String {
        logger.info { "Test method called" }
        return "HELLO"
    }
}