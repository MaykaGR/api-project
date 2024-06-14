package com.dam.api.repositories

import com.dam.api.models.Palabras
import org.springframework.data.repository.CrudRepository


/**
 * Repositorio para la entidad Palabras, proporcionando operaciones CRUD básicas.
 * Extiende CrudRepository, que proporciona métodos para guardar, eliminar, buscar y listar entidades.
 *
 * @see Palabras
 * @see CrudRepository
 */
interface PalabrasRepository: CrudRepository<Palabras, Long> {
}