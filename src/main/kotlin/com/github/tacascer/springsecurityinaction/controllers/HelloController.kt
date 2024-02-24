package com.github.tacascer.springsecurityinaction.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @GetMapping("/home")
    fun hello(): String {
        return "home.html"
    }
}