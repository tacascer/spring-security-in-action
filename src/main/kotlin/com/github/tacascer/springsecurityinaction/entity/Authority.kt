package com.github.tacascer.springsecurityinaction.entity

import jakarta.persistence.*

@Entity
class Authority(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var name: String,
    @JoinColumn(name = "user")
    @ManyToOne
    var user: User
)