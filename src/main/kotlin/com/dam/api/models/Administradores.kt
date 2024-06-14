package com.dam.api.models

import jakarta.persistence.*


/**
 * Entidad que representa a los administradores en el sistema.
 *
 * @property nombre el nombre del administrador
 * @property password la contraseña del administrador
 * @property id el identificador único de la entidad "Administradores"
 */
@Entity
@Table(name = "administradores")
class Administradores(

    /**
     * El nombre del administrador.
     *
     * Se mapea a la columna "nombre" en la tabla "administradores".
     */
    @Column(name = "nombre")
    var nombre: String,

    /**
     * La contraseña del administrador.
     *
     * Se mapea a la columna "password" en la tabla "administradores".
     */
    @Column(name = "password")
    var password: String,

    /**
     * El identificador único de la entidad "Administradores".
     *
     * Se genera automáticamente mediante la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long
){
}