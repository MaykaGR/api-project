package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name = "acertadas")
class Acertadas (
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_palabra")
    var palabra: Palabras,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="usuario_id")
    var usuario_id: Usuarios,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long
    ){

}