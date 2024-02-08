package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name = "administradores")
class Administradores(
    @Column(name = "nombre")
    var nombre: String,
    @Column(name = "password")
    var password: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long
){
}