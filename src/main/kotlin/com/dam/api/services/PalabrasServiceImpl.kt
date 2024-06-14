package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Palabras
import com.dam.api.repositories.PalabrasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service


/**
 * Implementación del servicio para la entidad Palabras.
 * Extiende GenericServiceImpl para heredar la implementación de métodos genéricos de servicio.
 *
 * @property palabrasRepository Repositorio de datos para la entidad Palabras
 * @property dao Repositorio CRUD utilizado por la implementación genérica
 */
@Service
class PalabrasServiceImpl: PalabrasServiceAPI, GenericServiceImpl<Palabras, Long>()  {

    /**
     * Repositorio de datos para la entidad Palabras, inyectado por Spring.
     */
    @Autowired
    lateinit var palabrasRepository: PalabrasRepository


    /**
     * Propiedad que devuelve el repositorio CRUD utilizado por la implementación genérica.
     */
    override val dao: CrudRepository<Palabras, Long>
        get() = palabrasRepository
}