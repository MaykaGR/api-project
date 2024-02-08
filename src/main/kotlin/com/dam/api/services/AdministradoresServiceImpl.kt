package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Administradores
import com.dam.api.repositories.AdministradoresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class AdministradoresServiceImpl: AdministradoresServiceAPI, GenericServiceImpl<Administradores, Long>() {
    @Autowired
    lateinit var administradoresRepository: AdministradoresRepository
    override val dao: CrudRepository<Administradores, Long>
        get() = administradoresRepository


}