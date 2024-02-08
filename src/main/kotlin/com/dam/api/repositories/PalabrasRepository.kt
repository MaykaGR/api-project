package com.dam.api.repositories

import com.dam.api.models.Palabras
import org.springframework.data.repository.CrudRepository

interface PalabrasRepository: CrudRepository<Palabras, Long> {
}