package com.iagxferreira.boilerplates.auth.infra.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.iagxferreira.boilerplates.auth.infra.entities.Role
import com.iagxferreira.boilerplates.auth.infra.entities.User
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "user_roles")
data class UserRole(


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonBackReference
    var role: Role,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID
}