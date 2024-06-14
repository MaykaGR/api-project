package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Usuarios
import com.dam.api.repositories.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service



/**
 * Implementación del servicio para la entidad Usuarios.
 * Extiende GenericServiceImpl para heredar la implementación de métodos genéricos de servicio.
 *
 * @property usuariosRepository Repositorio de datos para la entidad Usuarios
 * @property dao Repositorio CRUD utilizado por la implementación genérica
 */
@Service
class UsuariosServiceImpl: UsuariosServiceAPI, GenericServiceImpl<Usuarios, Long>() {

    /**
     * Repositorio de datos para la entidad Usuarios, inyectado por Spring.
     */
    @Autowired
    lateinit var usuariosRepository: UsuariosRepository

    /**
     * Propiedad que devuelve el repositorio CRUD utilizado por la implementación genérica.
     */
    override val dao: CrudRepository<Usuarios, Long>
        get() = usuariosRepository

}