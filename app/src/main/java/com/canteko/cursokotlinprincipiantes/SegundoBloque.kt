package com.canteko.cursokotlinprincipiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class SegundoBloque : AppCompatActivity() {

    companion object {
        private val tag = ":::TAG"

        fun condicionalesIf() {
            val firstNumber = 10
            val secondNumber = 5
            val booleanValue = true

            if (firstNumber > 5) {
                Log.d(tag, "Primera opcion")
                if (secondNumber == 4) {
                    Log.d(tag, "Primera opcion . 1")
                } else {
                    Log.d(tag, "Primera opcion . 2")

                }
            } else if (booleanValue) {
                Log.d(tag, "Segunda opcion")
            } else {
                Log.d(tag, "Tercera opcion")
            }

            val edad: Int = if (!booleanValue) {
                17
            } else {
                16
            }
            Log.d(tag, "Tu edad es $edad")
        }

        fun condicionalesWhen() {
            val language: String = "Kotlin"

            when (language) {
                "Kotlin", "Java", "Python", "JavaScript", "C", "C++", "C#", "Ruby" -> Log.d(
                    tag,
                    "Lenguaje seleccionado: $language"
                )
                "Php" -> {
                    Log.d(tag, "Lenguaje seleccionado: $language")
                    Log.d(tag, "Me he dao cuenta de que eres el puto amo, no?")
                }
                else -> Log.d(tag, "Otro lenguaje: $language")
            }

            val number: Int = 25

            when (number) {
                in 0..9 -> Log.d(tag, "Lenguaje seleccionado el rango de 0 a 9")
                in 10..19 -> Log.d(tag, "Lenguaje seleccionado el rango de 10 a 19")
                in 20..29 -> Log.d(tag, "Lenguaje seleccionado el rango de 20 a 29")
                in 30..39 -> Log.d(tag, "Lenguaje seleccionado el rango de 30 a 39")
                else -> Log.d(tag, "Lenguaje seleccionado el rango de 40 a *")
            }
        }

        fun listados() {
            val list1: List<String> = listOf()
            val list2 = listOf(String)

            val arrayList1: ArrayList<String> = arrayListOf()
            val arrayList2 = arrayListOf(String)

            val myList = listOf("String", "String2", "String3")
            val myArray = arrayListOf("String", "String2", "String3")
            val myArrayMultiple = arrayListOf("String", 4, 345.34, 43F, myList)

//        No se puede modificar el contenido de una lista
//        myList[2] = "Hola"
            myArray[2] = "Hola"

            Log.d(this.tag, myList[0])
            Log.d(this.tag, myArray[2])
            Log.d(this.tag, myArray.toString())

            myArray.remove("Hola")
            Log.d(this.tag, myArray.toString())

            myArray.removeAt(0)
            Log.d(this.tag, myArray.toString())

            myArray.addAll(myList)
            Log.d(this.tag, myArray.toString())

            Log.d(this.tag, myArrayMultiple.toString())
        }

        fun bucleFor() {
            val myList = listOf("String", "String2", "String3")
            val myArray = arrayListOf("String", "String2", "String3")
            val myArrayMultiple = arrayListOf("String", 4, 345.34, 43F, myList)

            for (element in myArrayMultiple) {
                Log.d(this.tag, "$element")
            }

            for (position in 1..10) {
                Log.d(this.tag, "$position")
            }

            for (position in 1..10) {
                Log.d(this.tag, "$position")
            }

            for (position in 0 until myArrayMultiple.size) {
                Log.d(this.tag, myArrayMultiple[position].toString())
            }

            for (position in 1..10 step 2) {
                Log.d(this.tag, "$position")
            }

            for(position in 90 downTo 10 step 5) {
                Log.d(this.tag, "$position")
            }
        }

        fun bucleWhile() {
            var myNumber = 10

            while (myNumber <= 20) {
                Log.d(tag, myNumber++.toString())
            }

            myNumber = 10
            while (myNumber <= 20) {
                myNumber += 2
                Log.d(tag, (myNumber).toString())
            }
        }

        fun bucleDoWhile() {
            var myNumber = 10

            do {
                myNumber += 2
                Log.d(tag, (myNumber).toString())
            } while (myNumber <= 20)
        }

        fun controlErrores() {
            val myArray = arrayListOf("String", "String2", "String3")
            val myString: String? = null

            try {

                Log.d(this.tag, myString!!)

                for (index in 0..myArray.size) {
                    Log.d(tag, myArray[index])
                }
            } catch (exception: Exception) {
                Log.d(tag, "Entramos en el Catch")
                exception.printStackTrace()
            } finally {
                Log.d(tag, "Entramos en el finally")
            }
        }

        data class Persona (
            val name: String,
            val age: Int,
            val hobbies: List<String>,
        )

        fun botDeSeguridad(persona: Persona): Int {
            if(persona.name != "Pakete") {
                Log.d(this.tag, "No eres la persona indicada, vete a la mierda ${persona.name}")
                return 0
            }
            Log.d(this.tag, "Adelante, Pakete")

            if(persona.age < 18) {
                Log.d(this.tag, "Aquí no entran menores de edad, y menos si tienes ${persona.age} años, niñato")
                return 0
            }

            if(persona.age >= 65) {
                Log.d(this.tag, "Aquí no entran yayos")
                return 0
            }

            Log.d(this.tag, "Enhorabuena Pakete, pasas el control de edad")

            for(hobby in persona.hobbies) {
                Log.d(this.tag, "Te gusta $hobby")
            }
            return 1
        }
    }
}