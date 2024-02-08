package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Palabras
import com.dam.api.repositories.PalabrasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PalabrasServiceImpl: PalabrasServiceAPI, GenericServiceImpl<Palabras, Long>()  {
    @Autowired
    lateinit var palabrasRepository: PalabrasRepository

    override val dao: CrudRepository<Palabras, Long>
        get() = palabrasRepository
}