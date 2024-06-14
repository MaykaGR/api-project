package com.dam.api.controllers

import com.dam.api.models.Usuarios
import com.dam.api.services.UsuariosServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * Controlador REST para manejar solicitudes relacionadas con entidades "Usuarios".
 *
 * Este controlador proporciona puntos de acceso para realizar operaciones CRUD
 * sobre las entidades "Usuarios".
 */
@RestController
@RequestMapping("/api_elnublado/v1/usuarios")
@CrossOrigin("*")
class UsuariosController {

    @Autowired
    lateinit var ser: UsuariosServiceImpl

    //URL -> /api_elnulado/v1/usuarios/

    /**
     * Obtiene todas las entidades "Usuarios".
     *
     * URL -> /api_elnublado/v1/usuarios/
     *
     * @return una lista mutable de todas las entidades "Usuarios"
     */
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Usuarios>> {
        val usuarios = ser.all
        return ResponseEntity(usuarios,HttpStatus.OK)
    }


    /**
     * Obtiene una entidad "Usuarios" por su identificador.
     *
     * @param id el identificador de la entidad "Usuarios"
     * @return la entidad "Usuarios" con el identificador dado, o una respuesta de error si no se encuentra
     */
    @GetMapping("/{id}")
    fun getOneUser(@PathVariable id: String): ResponseEntity<Usuarios>{
        val idUser: Long = id.toLong()
        val user: Usuarios? = ser[idUser]
        if(user!=null){
        return ResponseEntity<Usuarios>(user, HttpStatus.OK)}
        else{
            return ResponseEntity<Usuarios>(user, HttpStatus.BAD_REQUEST)
        }
    }


    /**
     * Elimina una entidad "Usuarios" por su identificador.
     *
     * @param id el identificador de la entidad "Usuarios" a eliminar
     * @return un mensaje indicando el resultado de la operación de eliminación
     */
    @DeleteMapping("/{id}")
    fun deleteOneUser(@PathVariable id: String): ResponseEntity<String>{
        val idUser: Long = id.toLong()
        ser.delete(idUser)
        val user = ser[idUser]
        if(user==null){
            return ResponseEntity("Borrado",HttpStatus.OK)
        } else {
            return ResponseEntity("No borrado "+user.nick, HttpStatus.BAD_REQUEST)
        }
    }


    /**
     * Inserta una nueva entidad "Usuarios".
     *
     * @param user la entidad "Usuarios" a insertar
     * @return un mensaje indicando el resultado de la operación de inserción
     */
    @PostMapping("/")
    fun insertUser(@RequestBody user: Usuarios): ResponseEntity<String>{
        var uuser = user
        uuser.password = user.password.hashCode().toString()
        val usuario = ser.save(uuser)
        if(usuario!=null){
            return ResponseEntity("Insertado "+user.nick+", tu id es el: "+user.id+" apúntalo, lo necesitarás para acceder a tu cuenta.",HttpStatus.OK)
        } else{
        return ResponseEntity("Error",HttpStatus.BAD_REQUEST)}
    }


    /**
     * Actualiza una entidad "Usuarios" existente.
     *
     * @param user la entidad "Usuarios" a actualizar
     * @param id el identificador de la entidad "Usuarios" a actualizar
     * @return un mensaje indicando el resultado de la operación de actualización
     */
    @PatchMapping("/{id}")
    fun updateUser(@RequestBody user: Usuarios, @PathVariable id: String): ResponseEntity<String>{
        val idUser = id.toLong()
        var modification = ser[idUser]
        if(getOneUser(user.id.toString())==ResponseEntity<Usuarios>(user, HttpStatus.OK)){
            modification = user
            val usuario = ser.save(modification)
            if(usuario!=null){
                return ResponseEntity("Cambiado el usuario con id "+user.id,HttpStatus.OK)
            } else{
                return ResponseEntity("Error",HttpStatus.BAD_REQUEST)}}
        else{
            return ResponseEntity("El usuario no existe", HttpStatus.BAD_REQUEST)
        }
    }

}

