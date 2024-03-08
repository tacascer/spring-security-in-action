package com.github.tacascer.springsecurityinaction.service

import com.github.tacascer.springsecurityinaction.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun findAll() = productRepository.findAll()
}