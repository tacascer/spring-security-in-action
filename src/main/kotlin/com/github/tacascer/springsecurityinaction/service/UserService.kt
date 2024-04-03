package com.github.tacascer.springsecurityinaction.service

import com.github.tacascer.springsecurityinaction.entities.Otp
import com.github.tacascer.springsecurityinaction.entities.User
import com.github.tacascer.springsecurityinaction.repository.OtpRepository
import com.github.tacascer.springsecurityinaction.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class UserService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val otpRepository: OtpRepository
) {
    fun addUser(user: User) {
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }

    fun auth(user: User) {
        userRepository.findUserByUsername(user.username)?.let {
            if (passwordEncoder.matches(user.password, it.password)) {
                renewOtp(it)
            } else {
                throw BadCredentialsException("Bad credentials.")
            }
        } ?: throw BadCredentialsException("Bad credentials.")
    }

    fun check(otpToValidate: Otp): Boolean {
        val otp = otpRepository.findOtpByUsername(otpToValidate.username)
        otp?.let {
            return otp.code == otpToValidate.code
        } ?: return false
    }

    private fun renewOtp(user: User) {
        val code = GenerateCodeUtil.generateCode();
        val otp = otpRepository.findOtpByUsername(user.username)
        otp?.let {
            it.code = code
        } ?: otpRepository.save(Otp(code, user.username))
    }
}