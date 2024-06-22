package com.iagxferreira.boilerplates.auth.validators

class EmailValidator {
    fun validate(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailRegex.toRegex())
    }
}