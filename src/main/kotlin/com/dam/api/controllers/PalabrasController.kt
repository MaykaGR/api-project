package com.dam.api.controllers

import com.dam.api.models.Palabras
import com.dam.api.services.PalabrasServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * Controlador REST para manejar solicitudes relacionadas con entidades "Palabras".
 *
 * Este controlador proporciona puntos de acceso para realizar operaciones CRUD
 * sobre las entidades "Palabras".
 */
@RestController
@RequestMapping("/api_elnublado/v1/palabras")
@CrossOrigin("*")
class PalabrasController {
    @Autowired
    lateinit var ser: PalabrasServiceImpl

    //URL -> /api_elnublado/v1/palabras/

    /**
     * Obtiene todas las entidades "Palabras".
     *
     * URL -> /api_elnublado/v1/palabras/
     *
     * @return una lista mutable de todas las entidades "Palabras"
     */
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Palabras>> {
        val palabras = ser.all
        return ResponseEntity(palabras, HttpStatus.OK)
    }



    /**
     * Obtiene una entidad "Palabras" por su identificador.
     *
     * @param id el identificador de la entidad "Palabras"
     * @return la entidad "Palabras" con el identificador dado, o una respuesta de error si no se encuentra
     */
    @GetMapping("/{id}")
    fun getOneWord(@PathVariable id: String): ResponseEntity<Palabras>{
        val idPalabra: Long = id.toLong()
        val palabra: Palabras? = ser[idPalabra]
        if(palabra!=null){
            return ResponseEntity<Palabras>(palabra, HttpStatus.OK)}
        else{
            return ResponseEntity<Palabras>(palabra, HttpStatus.BAD_REQUEST)
        }
    }


    /**
     * Recupera todas las entidades "Palabras".
     *
     * @return una lista mutable de todas las entidades "Palabras"
     */
    private fun allWords(): MutableList<Palabras>?{
        val words = ser.all
        return words
    }


    /**
     * Obtiene todas las entidades "Palabras" que tienen un número específico de letras.
     *
     * @param numletras el número de letras de las palabras a recuperar
     * @return una lista mutable de todas las entidades "Palabras" con el número dado de letras
     */
    @GetMapping("/num{numletras}")
    fun allNum(@PathVariable numletras: String): ResponseEntity<MutableList<Palabras>> {
        val cantidad = numletras.toInt()
        val all = allWords()?.sortedBy { it.numletras }
        val contador = (all?.size?: 1) -1
        val palabras: MutableList<Palabras> = mutableListOf()
        for(i in 0..contador){
            if(all?.get(i)!!.numletras == cantidad){
                palabras.add(all.get(i))
            }
        }
        return ResponseEntity(palabras,HttpStatus.OK)
    }



    /**
     * Elimina una entidad "Palabras" por su identificador.
     *
     * @param id el identificador de la entidad "Palabras" a eliminar
     * @return un mensaje indicando el resultado de la operación de eliminación
     */
    @DeleteMapping("/{id}")
    fun deleteOneWord(@PathVariable id: Long): ResponseEntity<String> {
        ser.delete(id)
        val palabra = ser[id]
        if(palabra==null){
            return ResponseEntity("Borrado", HttpStatus.OK)
        } else {
            return ResponseEntity("No borrado \""+palabra.palabra+"\" con id: "+palabra.id, HttpStatus.BAD_REQUEST)
        }
    }


    /**
     * Inserta una nueva entidad "Palabras".
     *
     * @param palabra la entidad "Palabras" a insertar
     * @return un mensaje indicando el resultado de la operación de inserción
     */
    @PostMapping("/")
    fun insertWord(@RequestBody palabra: Palabras): ResponseEntity<String> {
        val word = ser.save(palabra)
        if(word!=null){
            return ResponseEntity("Insertado \""+palabra.palabra+"\" con id: "+palabra.id, HttpStatus.OK)
        } else{
            return ResponseEntity("Error", HttpStatus.BAD_REQUEST)
        }
    }


    /**
     * Actualiza una entidad "Palabras" existente.
     *
     * @param palabra la entidad "Palabras" a actualizar
     * @return un mensaje indicando el resultado de la operación de actualización
     */
    @PutMapping("/")
    fun updateWord(@RequestBody palabra: Palabras): ResponseEntity<String> {
        val word = ser.save(palabra)
        if(word!=null){
            return ResponseEntity("Cambiada sesión con id "+palabra.id, HttpStatus.OK)
        } else{
            return ResponseEntity("Error", HttpStatus.BAD_REQUEST)
        }
    }

}