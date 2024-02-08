package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Acertadas
import com.dam.api.repositories.AcertadasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class AcertadasServiceImpl: AcertadasServiceAPI, GenericServiceImpl<Acertadas, Long>() {
    @Autowired
    lateinit var acertadasRepository: AcertadasRepository
    override val dao: CrudRepository<Acertadas, Long>
        get() = acertadasRepository


}