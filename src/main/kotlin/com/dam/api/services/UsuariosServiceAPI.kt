package com.dam.api.services

import com.dam.api.commons.GenericServiceAPI
import com.dam.api.models.Usuarios


/**
 * Interfaz que define las operaciones específicas para el servicio relacionado con la entidad Usuarios.
 * Extiende la interfaz genérica GenericServiceAPI proporcionando métodos para guardar, eliminar, buscar y obtener todas las instancias de Usuarios.
 *
 * @see Usuarios
 * @see GenericServiceAPI
 */
interface UsuariosServiceAPI: GenericServiceAPI<Usuarios, Long> {
}