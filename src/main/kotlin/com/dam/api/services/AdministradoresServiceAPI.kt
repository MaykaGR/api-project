package com.dam.api.services

import com.dam.api.commons.GenericServiceAPI
import com.dam.api.models.Administradores


/**
 * Interfaz que define las operaciones específicas para el servicio relacionado con la entidad Administradores.
 * Extiende la interfaz genérica GenericServiceAPI proporcionando métodos para guardar, eliminar, buscar y obtener todas las instancias de Administradores.
 *
 * @see Administradores
 * @see GenericServiceAPI
 */
interface AdministradoresServiceAPI: GenericServiceAPI<Administradores, Long> {
}