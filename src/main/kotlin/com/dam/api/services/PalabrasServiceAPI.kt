package com.dam.api.services

import com.dam.api.commons.GenericServiceAPI
import com.dam.api.models.Palabras


/**
 * Interfaz que define las operaciones específicas para el servicio relacionado con la entidad Palabras.
 * Extiende la interfaz genérica GenericServiceAPI proporcionando métodos para guardar, eliminar, buscar y obtener todas las instancias de Palabras.
 *
 * @see Palabras
 * @see GenericServiceAPI
 */
interface PalabrasServiceAPI: GenericServiceAPI<Palabras, Long> {
}