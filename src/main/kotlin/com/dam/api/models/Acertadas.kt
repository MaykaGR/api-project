package com.dam.api.models

import jakarta.persistence.*


/**
 * Entidad que representa las palabras acertadas por los usuarios.
 *
 * @property palabra la palabra acertada, representada por una entidad de tipo [Palabras]
 * @property usuario_id el usuario que acertó la palabra, representado por una entidad de tipo [Usuarios]
 * @property id el identificador único de la entidad "Acertadas"
 */
@Entity
@Table(name = "acertadas")
class Acertadas (

    /**
     * La palabra acertada, asociada a esta entidad.
     *
     * Se utiliza una relación de uno a uno con cascada total para la entidad [Palabras].
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_palabra")
    var palabra: Palabras,

    /**
     * El usuario que acertó la palabra, asociado a esta entidad.
     *
     * Se utiliza una relación de muchos a uno con cascada total para la entidad [Usuarios].
     */
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="usuario_id")
    var usuario_id: Usuarios,

    /**
     * El identificador único de la entidad "Acertadas".
     *
     * Se genera automáticamente mediante la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long
    ){

}