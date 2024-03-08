package com.github.tacascer.springsecurityinaction.entity

import jakarta.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var username: String,
    var password: String,
    @Enumerated(EnumType.STRING)
    var algorithm: EncryptionAlgorithm,
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    var authorities: MutableList<Authority>
)

enum class EncryptionAlgorithm {
    BCRYPT, SCRYPT
}