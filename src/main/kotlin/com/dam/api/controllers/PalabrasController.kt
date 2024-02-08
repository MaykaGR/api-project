package com.dam.api.controllers

import com.dam.api.models.Palabras
import com.dam.api.services.PalabrasServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api_elnublado/v1/palabras")
@CrossOrigin("*")
class PalabrasController {
    @Autowired
    lateinit var ser: PalabrasServiceImpl

    //URL -> /api_elnublado/v1/palabras/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Palabras>> {
        val palabras = ser.all
        return ResponseEntity(palabras, HttpStatus.OK)
    }


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

    private fun allWords(): MutableList<Palabras>?{
        val words = ser.all
        return words
    }

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

    @PostMapping("/")
    fun insertWord(@RequestBody palabra: Palabras): ResponseEntity<String> {
        val word = ser.save(palabra)
        if(word!=null){
            return ResponseEntity("Insertado \""+palabra.palabra+"\" con id: "+palabra.id, HttpStatus.OK)
        } else{
            return ResponseEntity("Error", HttpStatus.BAD_REQUEST)
        }
    }

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