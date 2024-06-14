package com.dam.api.repositories

import com.dam.api.models.Acertadas
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


/**
 * Repositorio para la entidad Acertadas, proporcionando operaciones CRUD básicas.
 * Extiende CrudRepository, que proporciona métodos para guardar, eliminar, buscar y listar entidades.
 *
 * @see Acertadas
 * @see CrudRepository
 */
@Repository
interface AcertadasRepository: CrudRepository<Acertadas, Long> {
}