package com.iagxferreira.boilerplates.auth.infra.repositories

import com.iagxferreira.boilerplates.auth.infra.entities.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Role?
}