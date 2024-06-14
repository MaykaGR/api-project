package com.dam.api.models

import jakarta.persistence.*


/**
 * Entidad que representa a los usuarios en el sistema.
 *
 * @property nick el nombre de usuario (nick)
 * @property password la contraseña del usuario
 * @property acertadas las palabras acertadas por el usuario, representadas por un conjunto de entidades [Acertadas]
 * @property nivel el nivel del usuario
 * @property puntos los puntos acumulados por el usuario
 * @property id el identificador único de la entidad "Usuarios"
 */
@Entity
@Table(name = "usuarios")
class Usuarios (

    /**
     * El nombre de usuario (nick).
     *
     * Se mapea a la columna "nick" en la tabla "usuarios".
     */
    @Column(name = "nick")
    var nick: String,

    /**
     * La contraseña del usuario.
     *
     * Se mapea a la columna "password" en la tabla "usuarios".
     */
    @Column(name= "password")
    var password: String,

    /**
     * Las palabras acertadas por el usuario.
     *
     * Se establece una relación de uno a muchos con la entidad [Acertadas], mapeada por el campo "usuario_id".
     * Utiliza cascada completa y carga perezosa (lazy).
     */
    @OneToMany(mappedBy = "usuario_id", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val acertadas: MutableSet<Acertadas> = mutableSetOf(),

    /**
     * El nivel del usuario.
     *
     * Se mapea a la columna "nivel" en la tabla "usuarios".
     */
    @Column(name = "nivel")
    var nivel: Int = 0,

    /**
     * Los puntos acumulados por el usuario.
     *
     * Se mapea a la columna "puntos" en la tabla "usuarios".
     */
    @Column(name = "puntos")
    var puntos: Int = 0,

    /**
     * El identificador único de la entidad "Usuarios".
     *
     * Se genera automáticamente mediante la estrategia de generación de identidad.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long
    ){

}