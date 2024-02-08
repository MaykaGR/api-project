package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
class Usuarios (
    @Column(name = "nick")
    var nick: String,
    @Column(name= "password")
    var password: String,
    @OneToMany(mappedBy = "usuario_id", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val acertadas: MutableSet<Acertadas> = mutableSetOf(),
    @Column(name = "nivel")
    var nivel: Int = 0,
    @Column(name = "puntos")
    var puntos: Int = 0,
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long
    ){

}