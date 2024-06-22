package com.iagxferreira.boilerplates.auth

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Spring Auth POC", version = "v1"))

class AuthApplication

fun main(args: Array<String>) {
	runApplication<AuthApplication>(*args)
}
