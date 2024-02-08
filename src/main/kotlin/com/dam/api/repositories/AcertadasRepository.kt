package com.dam.api.repositories

import com.dam.api.models.Acertadas
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AcertadasRepository: CrudRepository<Acertadas, Long> {
}