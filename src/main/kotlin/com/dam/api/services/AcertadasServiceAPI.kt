package com.dam.api.services

import com.dam.api.commons.GenericServiceAPI
import com.dam.api.models.Acertadas


/**
 * Interfaz que define las operaciones específicas para el servicio relacionado con la entidad Acertadas.
 * Extiende la interfaz genérica GenericServiceAPI proporcionando métodos para guardar, eliminar, buscar y obtener todas las instancias de Acertadas.
 *
 * @see Acertadas
 * @see GenericServiceAPI
 */
interface AcertadasServiceAPI: GenericServiceAPI<Acertadas, Long> {
}