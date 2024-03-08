package com.github.tacascer.springsecurityinaction.entity

import jakarta.persistence.*

@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int,
    var name: String,
    var price: Double,
    @Enumerated(EnumType.STRING)
    var currency: Currency
) {
}

enum class Currency {
    USD, EUR, GBP
}