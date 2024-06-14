package com.dam.api.commons


/**
 * Interfaz para una API de servicio genérico.
 *
 * Esta interfaz define las operaciones básicas de CRUD para un tipo genérico `T`
 * con un identificador de tipo `ID`.
 *
 * @param T el tipo de la entidad
 * @param ID el tipo del identificador
 */
interface GenericServiceAPI<T, ID> {

    /**
     * Guarda la entidad dada.
     *
     * @param entity la entidad a guardar
     * @return la entidad guardada
     */
    fun save(entity:T): T

    /**
     * Elimina la entidad con el identificador dado.
     *
     * @param id el identificador de la entidad a eliminar
     */
    fun delete(id: ID)

    /**
     * Recupera la entidad con el identificador dado.
     *
     * @param id el identificador de la entidad a recuperar
     * @return la entidad con el identificador dado, o null si no se encuentra
     */
    operator fun get(id: ID): T?

    /**
     * Recupera todas las entidades.
     *
     * @return una lista mutable de todas las entidades, o null si no se encuentran entidades
     */
    val all: MutableList<T>?

    // Método comentado que recupera todas las entidades.
    //fun getAll()

}