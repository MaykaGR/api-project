package com.dam.api.models
import jakarta.persistence.*


/**
 * Entidad que representa las palabras en el sistema.
 *
 * @property palabra la palabra en sí
 * @property letraemp la letra con la que empieza la palabra
 * @property numletras el número de letras de la palabra
 * @property id el identificador único de la entidad "Palabras"
 */
@Entity
@Table(name = "palabras")
class Palabras(

    /**
     * La palabra en sí.
     *
     * Se mapea a la columna "palabra" en la tabla "palabras".
     */
    @Column(name="palabra")
    var palabra: String,

    /**
     * La letra con la que empieza la palabra.
     *
     * Se mapea a la columna "letraempiezo" en la tabla "palabras".
     */
    @Column(name = "letraempiezo")
    var letraemp: String,

    /**
     * El número de letras de la palabra.
     *
     * Se mapea a la columna "numletras" en la tabla "palabras".
     */
    @Column(name = "numletras")
    var numletras: Int,

    /**
     * El identificador único de la entidad "Palabras".
     *
     * Se genera automáticamente mediante la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long) {
}