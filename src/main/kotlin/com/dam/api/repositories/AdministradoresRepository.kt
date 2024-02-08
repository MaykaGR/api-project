package com.dam.api.repositories

import com.dam.api.models.Administradores
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AdministradoresRepository: CrudRepository<Administradores, Long> {
}