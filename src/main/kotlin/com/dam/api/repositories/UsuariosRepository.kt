package com.dam.api.repositories

import com.dam.api.models.Usuarios
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


/**
 * Repositorio para la entidad Usuarios, proporcionando operaciones CRUD básicas.
 * Extiende CrudRepository, que proporciona métodos para guardar, eliminar, buscar y listar entidades.
 *
 * @see Usuarios
 * @see CrudRepository
 */
@Repository
interface UsuariosRepository: CrudRepository<Usuarios, Long> {
}