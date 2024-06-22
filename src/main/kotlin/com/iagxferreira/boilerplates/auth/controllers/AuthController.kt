package com.iagxferreira.boilerplates.auth.controllers

import com.iagxferreira.boilerplates.auth.controllers.viewmodels.auth.AuthRequest
import com.iagxferreira.boilerplates.auth.controllers.viewmodels.auth.AuthResponse
import com.iagxferreira.boilerplates.auth.controllers.viewmodels.auth.RegisterRequest
import com.iagxferreira.boilerplates.auth.infra.entities.User
import com.iagxferreira.boilerplates.auth.services.TokenService
import com.iagxferreira.boilerplates.auth.services.UserService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/auth")
class AuthController internal constructor(
    private val tokenService: TokenService,
    private val userService: UserService,
    private val authenticationManager: AuthenticationManager,
) {
    @PostMapping("register")
    fun addNewUser(@Valid @RequestBody request: RegisterRequest): ResponseEntity<User> {
        return ResponseEntity.ok(this.userService.insert(request))
    }

    @PostMapping("login")
    fun login(@RequestBody() authRequest: AuthRequest): ResponseEntity<AuthResponse> {
        val user = this.userService.byEmail(authRequest.email)
        val usernamePassword = UsernamePasswordAuthenticationToken(user?.id, authRequest.password)
        val auth = authenticationManager.authenticate(usernamePassword)

        val token = tokenService.generate(auth.principal as User)

        return ResponseEntity.ok(AuthResponse(token!!))
    }


    @GetMapping("/profile")
    @SecurityRequirement(name = "bearerAuth")
    fun profile(principal: Principal): String {
        return principal.name
    }

    @GetMapping("/admin-profile")
    @SecurityRequirement(name = "bearerAuth")
    fun adminProfile(principal: Principal): Principal {
        return principal
    }

}