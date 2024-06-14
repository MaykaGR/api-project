package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Acertadas
import com.dam.api.repositories.AcertadasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service


/**
 * Implementación del servicio para la entidad Acertadas.
 * Extiende GenericServiceImpl para heredar la implementación de métodos genéricos de servicio.
 *
 * @property acertadasRepository Repositorio de datos para la entidad Acertadas
 * @property dao Repositorio CRUD utilizado por la implementación genérica
 */
@Service
class AcertadasServiceImpl: AcertadasServiceAPI, GenericServiceImpl<Acertadas, Long>() {

    /**
     * Repositorio de datos para la entidad Acertadas, inyectado por Spring.
     */
    @Autowired
    lateinit var acertadasRepository: AcertadasRepository

    /**
     * Propiedad que devuelve el repositorio CRUD utilizado por la implementación genérica.
     */
    override val dao: CrudRepository<Acertadas, Long>
        get() = acertadasRepository


}