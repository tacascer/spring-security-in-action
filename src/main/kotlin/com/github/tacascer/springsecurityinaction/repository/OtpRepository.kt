package com.github.tacascer.springsecurityinaction.repository

import com.github.tacascer.springsecurityinaction.entities.Otp
import org.springframework.data.jpa.repository.JpaRepository

interface OtpRepository : JpaRepository<Otp, String> {
    fun findOtpByUsername(username: String): Otp?
}