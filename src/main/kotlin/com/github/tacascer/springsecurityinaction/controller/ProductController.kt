package com.github.tacascer.springsecurityinaction.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {
    @GetMapping("/product/{code}")
    fun productCode(@PathVariable code: String) = code
}