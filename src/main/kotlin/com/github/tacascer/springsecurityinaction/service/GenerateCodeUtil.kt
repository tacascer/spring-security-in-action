package com.github.tacascer.springsecurityinaction.service

import java.security.NoSuchAlgorithmException
import java.security.SecureRandom

class GenerateCodeUtil {
    companion object {
        fun generateCode(): String {
            try {
                val random = SecureRandom.getInstanceStrong()
                return (random.nextInt(9000) + 1000).toString()
            } catch (e: NoSuchAlgorithmException) {
                throw RuntimeException("Problem with generating code.")
            }
        }
    }
}
