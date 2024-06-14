package com.dam.api.commons

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


/**
 * Implementación genérica de la interfaz `GenericServiceAPI`.
 *
 * Esta clase abstracta proporciona una implementación básica de las operaciones CRUD
 * utilizando un `CrudRepository` de Spring Data.
 *
 * @param T el tipo de la entidad
 * @param ID el tipo del identificador
 */
@Service
abstract class GenericServiceImpl<T: Any, ID: Any>: GenericServiceAPI<T, ID> {

    /**
     * Guarda la entidad dada.
     *
     * @param entity la entidad a guardar
     * @return la entidad guardada
     */
    override fun save(entity: T): T{
        return dao.save(entity)
    }


    /**
     * Elimina la entidad con el identificador dado.
     *
     * @param id el identificador de la entidad a eliminar
     */
    override fun delete(id: ID) {
        dao.deleteById(id)
    }


    /**
     * Recupera la entidad con el identificador dado.
     *
     * @param id el identificador de la entidad a recuperar
     * @return la entidad con el identificador dado, o null si no se encuentra
     */
    override fun get(id: ID): T? {
        return dao.findByIdOrNull(id)
    }


    /**
     * Recupera todas las entidades.
     *
     * @return una lista mutable de todas las entidades, o null si no se encuentran entidades
     */
    override val all: MutableList<T>?
        get() {
            val returnList: MutableList<T> = ArrayList()
            dao.findAll().forEach{obj: T -> returnList.add(obj)}
            return returnList
        }


    /**
     * El DAO (Data Access Object) para realizar operaciones CRUD en la base de datos.
     *
     * Esta propiedad debe ser implementada por la subclase concreta.
     */
    abstract val dao: CrudRepository<T, ID>
}