package com.dam.api.controllers

import com.dam.api.models.Administradores
import com.dam.api.services.AdministradoresServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



/**
 * Controlador REST para manejar solicitudes relacionadas con entidades "Administradores".
 *
 * Este controlador proporciona puntos de acceso para realizar operaciones CRUD
 * sobre las entidades "Administradores".
 */
@RestController
@RequestMapping("/api_elnublado/v1/administradores")
@CrossOrigin("*")
class AdministradoresController {
    @Autowired
    lateinit var ser: AdministradoresServiceImpl

    //URL -> /api_elnublado/v1/administradores/

    /**
     * Obtiene todas las entidades "Administradores".
     *
     * URL -> /api_elnublado/v1/administradores/
     *
     * @return una lista mutable de todas las entidades "Administradores"
     */
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Administradores>> {
        val administradores = ser.all
        return ResponseEntity(administradores, HttpStatus.OK)
    }


    /**
     * Obtiene una entidad "Administradores" por su identificador.
     *
     * @param id el identificador de la entidad "Administradores"
     * @return la entidad "Administradores" con el identificador dado
     */
    @GetMapping("/{id}")
    fun getOneAdmin(@PathVariable id: String): ResponseEntity<Administradores> {
        val idAdmin = id.toLong()
        val administrador: Administradores? = ser[idAdmin]
        return ResponseEntity<Administradores>(administrador, HttpStatus.OK)
    }


    /**
     * Elimina una entidad "Administradores" por su identificador.
     *
     * @param id el identificador de la entidad "Administradores" a eliminar
     * @return un mensaje indicando el resultado de la operación de eliminación
     */
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


    /**
     * Inserta una nueva entidad "Administradores".
     *
     * @param admin la entidad "Administradores" a insertar
     * @return un mensaje indicando el resultado de la operación de inserción
     */
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


    /**
     * Actualiza una entidad "Administradores" existente.
     *
     * @param admin la entidad "Administradores" a actualizar
     * @param id el identificador de la entidad "Administradores" a actualizar
     * @return un mensaje indicando el resultado de la operación de actualización
     */
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