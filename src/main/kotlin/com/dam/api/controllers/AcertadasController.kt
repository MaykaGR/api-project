package com.dam.api.controllers

import com.dam.api.models.Acertadas
import com.dam.api.services.AcertadasServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api_elnublado/v1/acertadas")
@CrossOrigin("*")
class AcertadasController {

    @Autowired
    lateinit var ser: AcertadasServiceImpl

    //URL -> /api_elnulado/v1/acertadas/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Acertadas>> {
        val acertadas = ser.all
        return ResponseEntity(acertadas,HttpStatus.OK)
    }
    // Forma de buscar "id_palabra , id_usuario"
    @GetMapping("/{id}")
    fun getOnePalabra(@PathVariable id: String): ResponseEntity<Acertadas>{
        val idpalabra = id.toLong()
        val palabra: Acertadas? = ser[idpalabra]
        return ResponseEntity<Acertadas>(palabra, HttpStatus.OK)
    }

    @GetMapping("/acertadasUser{id}")
    fun getAllFromUser(@PathVariable id: String): ResponseEntity<MutableList<Acertadas>>{
        val idUser = id.toLong()
        val acertadas = ser.all
        val acertadasUser: MutableList<Acertadas> = mutableListOf()
        val contador = (acertadas?.size?: 1) -1
        for(i in 0..contador){
            if(acertadas!![i].usuario_id.id == idUser){
                acertadasUser.add(acertadas[i])
            }
        }
        return ResponseEntity(acertadasUser,HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteOnePalabra(@PathVariable id: String): ResponseEntity<String>{
        val idpalabra = id.toLong()
        ser.delete(idpalabra)
        val palabra = ser[idpalabra]
        if(palabra==null){
            return ResponseEntity("Borrado",HttpStatus.OK)
        } else {
            return ResponseEntity("No borrado "+palabra.palabra.palabra, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/")
    fun insertAcertada(@RequestBody acertada: Acertadas): ResponseEntity<String>{
        val word = ser.save(acertada)
        if(word!=null){
            return ResponseEntity("Insertado "+acertada.palabra.palabra,HttpStatus.OK)
        } else{
        return ResponseEntity("Error",HttpStatus.BAD_REQUEST)}
    }

    @PutMapping("/")
    fun updateAcertada(@RequestBody acertada: Acertadas): ResponseEntity<String>{
        val word = getOnePalabra("${acertada.palabra.id},${acertada.usuario_id.id}")
        if(word!=null){
        val modification = ser.save(acertada)
        if(modification!=null){
            return ResponseEntity("Cambiada palabra "+acertada.palabra.palabra,HttpStatus.OK)
        } else{
            return ResponseEntity("Error",HttpStatus.BAD_REQUEST)}}
        else{
            return ResponseEntity("Error, valor no existente",HttpStatus.BAD_REQUEST)
        }
    }


}