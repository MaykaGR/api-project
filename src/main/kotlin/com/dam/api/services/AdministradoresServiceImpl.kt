package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Administradores
import com.dam.api.repositories.AdministradoresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service


/**
 * Implementación del servicio para la entidad Administradores.
 * Extiende GenericServiceImpl para heredar la implementación de métodos genéricos de servicio.
 *
 * @property administradoresRepository Repositorio de datos para la entidad Administradores
 * @property dao Repositorio CRUD utilizado por la implementación genérica
 */
@Service
class AdministradoresServiceImpl: AdministradoresServiceAPI, GenericServiceImpl<Administradores, Long>() {

    /**
     * Repositorio de datos para la entidad Administradores, inyectado por Spring.
     */
    @Autowired
    lateinit var administradoresRepository: AdministradoresRepository

    /**
     * Propiedad que devuelve el repositorio CRUD utilizado por la implementación genérica.
     */
    override val dao: CrudRepository<Administradores, Long>
        get() = administradoresRepository


}