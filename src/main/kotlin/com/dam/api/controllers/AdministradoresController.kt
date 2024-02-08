package com.dam.api.controllers

import com.dam.api.models.Administradores
import com.dam.api.services.AdministradoresServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api_elnublado/v1/administradores")
@CrossOrigin("*")
class AdministradoresController {
    @Autowired
    lateinit var ser: AdministradoresServiceImpl

    //URL -> /api_elnublado/v1/administradores/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Administradores>> {
        val administradores = ser.all
        return ResponseEntity(administradores, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getOneAdmin(@PathVariable id: String): ResponseEntity<Administradores> {
        val idAdmin = id.toLong()
        val administrador: Administradores? = ser[idAdmin]
        return ResponseEntity<Administradores>(administrador, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteOneAdmin(@PathVariable id: String): ResponseEntity<String> {
        val idAdmin = id.toLong()
        ser.delete(idAdmin)
        val admin = ser[idAdmin]
        if(admin==null){
            return ResponseEntity("Borrado", HttpStatus.OK)
        } else {
            return ResponseEntity("No borrado "+admin.nombre, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/")
    fun insertAdmin(@RequestBody admin: Administradores): ResponseEntity<String> {
        var aadmin = admin
        aadmin.password = admin.password.hashCode().toString()
        val administrador = ser.save(admin)
        if(administrador!=null){
            return ResponseEntity("Insertado "+admin.nombre+", tu id es: "+admin.id, HttpStatus.OK)
        } else{
            return ResponseEntity("Error", HttpStatus.BAD_REQUEST)
        }
    }

    @PutMapping("/{id}")
    fun updateAdmin(@RequestBody admin: Administradores, @PathVariable id: String): ResponseEntity<String> {
        val idAdmin = id.toLong()
        var adminU = ser[idAdmin]
        if(adminU!=null){
        adminU = admin
        val guardado = ser.save(adminU)
        if(guardado!=null){
            return ResponseEntity("Cambiado administrador "+admin.nombre, HttpStatus.OK)
        } else{
            return ResponseEntity("Error", HttpStatus.BAD_REQUEST)
        }} else {
            return ResponseEntity("El administrador no existe", HttpStatus.NOT_FOUND)
        }
    }
}