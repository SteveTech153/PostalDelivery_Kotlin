package com.sample.postaldelivery.system.action

interface PasswordActions {
    fun hashPassword(password: String): String
    fun checkPassword(originalPassword: String, hashedPassword: String): Boolean
}