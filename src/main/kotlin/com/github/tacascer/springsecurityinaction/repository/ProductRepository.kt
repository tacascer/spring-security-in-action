package com.github.tacascer.springsecurityinaction.repository

import com.github.tacascer.springsecurityinaction.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {

}