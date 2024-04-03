package com.github.tacascer.springsecurityinaction.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Otp(
    var code: String,
    @Id
    var username: String,
) {
}