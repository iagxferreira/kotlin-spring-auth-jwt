package com.iagxferreira.boilerplates.auth.controllers.viewmodels.auth

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
)
