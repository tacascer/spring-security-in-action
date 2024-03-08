package com.github.tacascer.springsecurityinaction.controllers

import com.github.tacascer.springsecurityinaction.service.ProductService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainPageController(private val productService: ProductService) {
    @GetMapping("/main")
    fun main(authentication: Authentication, model: Model): String {
        model.addAttribute("username", authentication.name)
        model.addAttribute("products", productService.findAll())
        return "main.html"
    }
}