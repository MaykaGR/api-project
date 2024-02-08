package com.dam.api.models
import jakarta.persistence.*

@Entity
@Table(name = "palabras")
class Palabras(
    @Column(name="palabra")
    var palabra: String,
    @Column(name = "letraempiezo")
    var letraemp: String,
    @Column(name = "numletras")
    var numletras: Int,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long) {
}