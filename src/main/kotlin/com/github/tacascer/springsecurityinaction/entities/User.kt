package com.github.tacascer.springsecurityinaction.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User (
    var password: String,
    @Id
    var username: String,
) {

}