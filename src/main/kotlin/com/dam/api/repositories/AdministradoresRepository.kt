package com.dam.api.repositories

import com.dam.api.models.Administradores
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


/**
 * Repositorio para la entidad Administradores, proporcionando operaciones CRUD básicas.
 * Extiende CrudRepository, que proporciona métodos para guardar, eliminar, buscar y listar entidades.
 *
 * @see Administradores
 * @see CrudRepository
 */
@Repository
interface AdministradoresRepository: CrudRepository<Administradores, Long> {
}