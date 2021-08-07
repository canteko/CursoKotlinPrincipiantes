package com.canteko.cursokotlinprincipiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {
    private val tag = ":::TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        PrimerBloque.variablesYConstantes()
//        PrimerBloque.tiposDeDatos()
//        PrimerBloque.operadores()
//        PrimerBloque.nullSafety()
//        PrimerBloque.funciones()
//        PrimerBloque.clases()
//        PrimerBloque.interfaces()
//        PrimerBloque.reto("Francisco", 26, "php")

//        SegundoBloque.condicionalesIf()
//        SegundoBloque.condicionalesWhen()
//        SegundoBloque.listados()
//        SegundoBloque.bucleFor()
//        SegundoBloque.bucleWhile()
//        SegundoBloque.bucleDoWhile()
//        SegundoBloque.controlErrores()

        val hobbies = arrayListOf("Programar", "Ver MMA", "Salir con mis amigos")
        val pakete: SegundoBloque.Companion.Persona =
            SegundoBloque.Companion.Persona("Pakete", 26, hobbies)
        val edu: SegundoBloque.Companion.Persona =
            SegundoBloque.Companion.Persona("Edu", 26, hobbies)
        val bule: SegundoBloque.Companion.Persona =
            SegundoBloque.Companion.Persona("Bule", 26, hobbies)
        val enano: SegundoBloque.Companion.Persona =
            SegundoBloque.Companion.Persona("Pakete", 12, hobbies)
        val yayo: SegundoBloque.Companion.Persona =
            SegundoBloque.Companion.Persona("Pakete", 89, hobbies)

        val arrayPersonas = arrayListOf(pakete, edu, bule, enano, yayo)
        for (persona in arrayPersonas) {
            SegundoBloque.botDeSeguridad(persona)
        }

    }
}