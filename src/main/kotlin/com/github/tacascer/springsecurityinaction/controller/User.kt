package com.github.tacascer.springsecurityinaction.controller

data class User(
    private val username: String,
    private val password: String,
    private val code: String
) {
}