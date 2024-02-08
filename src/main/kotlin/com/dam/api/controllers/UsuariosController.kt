package com.dam.api.controllers

import com.dam.api.models.Usuarios
import com.dam.api.services.UsuariosServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api_elnublado/v1/usuarios")
@CrossOrigin("*")
class UsuariosController {

    @Autowired
    lateinit var ser: UsuariosServiceImpl

    //URL -> /api_elnulado/v1/usuarios/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Usuarios>> {
        val usuarios = ser.all
        return ResponseEntity(usuarios,HttpStatus.OK)
    }

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

    @PutMapping("/")
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

