package com.canteko.cursokotlinprincipiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class StartingInKotlin : AppCompatActivity() {
    private val tag = ":::TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.variablesYConstantes()
        this.tiposDeDatos()
        this.operadores()
        this.nullSafety()
        this.funciones()
        this.clases()
        this.interfaces()
        this.reto("Francisco", 26, "php")
        this.reto("Francisco", 26, "php")
    }

    /**
     * Aquí vamos a ver variables y constantes
     */
    private fun variablesYConstantes() {
        /*
        1. - Nombre para representar el valor de un dato
         */

        var myFirstVariable = "Hello world!"
        myFirstVariable = "Bye world!"

        val myFirstConstant = "Hello world!"
        Log.d(tag, myFirstVariable)
    }

    private fun tiposDeDatos() {
        // Cadena de texto
        var string = "My string"
        // Valores numericos (Int, Short, Long, Byte)
        var number = 10
        // Valores nmumericos decimales (double, float)
        var decimal = 10.43
        // Condiciones verdaderas o falsas
        var boolean = false
        var boolean2 = true

        Log.d(tag, "My number is this one: $number")
    }

    private fun operadores() {
        val firstValue = 5.0
        val secondValue = 2.0

        var thirdValue = firstValue + secondValue
        // Operadores aritméticos
        Log.d(tag, "El resultado de $firstValue + $secondValue es $thirdValue")
        thirdValue = firstValue - secondValue
        Log.d(tag, "El resultado de $firstValue - $secondValue es $thirdValue")
        thirdValue = firstValue / secondValue
        Log.d(tag, "El resultado de $firstValue / $secondValue es $thirdValue")
        thirdValue = firstValue * secondValue
        Log.d(tag, "El resultado de $firstValue * $secondValue es $thirdValue")
        thirdValue = firstValue % secondValue
        Log.d(tag, "El resultado de $firstValue % $secondValue es $thirdValue")

        // Operadores de comparación
        val equal = firstValue == secondValue
        Log.d(tag, "El resultado de $firstValue == $secondValue es $equal")
        val notEqual = firstValue != secondValue
        Log.d(tag, "El resultado de $firstValue != $secondValue es $notEqual")
        val smaller = firstValue < secondValue
        Log.d(tag, "El resultado de $firstValue < $secondValue es $smaller")
        val greater = firstValue == secondValue
        Log.d(tag, "El resultado de $firstValue > $secondValue es $greater")
        val smallerEqual = firstValue == secondValue
        Log.d(tag, "El resultado de $firstValue <= $secondValue es $smallerEqual")
        val greaterEqual = firstValue == secondValue
        Log.d(tag, "El resultado de $firstValue >= $secondValue es $greaterEqual")

        // Operadores logicos
        val name = "Francisco"
        val age = 26

        val igualdad2 = (name == "Francisco")
        val menorQue2 = (age > 50)

        val conjuncion = igualdad2 && menorQue2
        val disyuncion = igualdad2 || menorQue2
        val negacion = !igualdad2
        Log.d(tag, "El resultado de conjuncion es $conjuncion")
        Log.d(tag, "El resultado de disyuncion es $disyuncion")
        Log.d(tag, "El resultado de negacion es $negacion")
    }

    private fun nullSafety() {
        val nullString: String? = null

        nullString?.let {
            Log.d(tag, nullString)
        } ?: run {
            Log.d(tag, "null")
        }
    }

    private fun funciones() {
        funcionSimple()
        funcionParametros("Pakete", 24, "Electricista")
        funcionParametros()
        val edad = funcionRetorno(1995)
        Log.d(tag, "Tu edad es $edad")
    }

    private fun funcionParametros(name: String = "Francisco", age: Int = 26, job: String? = "Enformateco") {
        Log.d(tag, name)
        Log.d(tag, age.toString())
        Log.d(tag, "$job")
    }

    private fun funcionSimple() {
        Log.d(tag, "Francisco")
        Log.d(tag, 26.toString())
    }

    private fun funcionRetornoInline(birthYear: Int): Int = Calendar.getInstance().get(Calendar.YEAR) - birthYear

    private fun funcionRetorno(birthYear: Int): Int {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        return year - birthYear
    }

    private fun clases() {
        val personaData = PersonData("Pakete", 26, 1995)
        val persona2Data = PersonData("Edulio", 26, 1995)
        val persona3Data = PersonData("Bulete", 26, 1995)
        val persona4Data = PersonData("Manolita", 24, 1997)
        val persona = Persona(personaData)
        val persona2 = Persona(persona2Data)
        val persona3 = Persona(persona3Data)
        val persona4 = Persona(persona4Data)
        persona.presentacion()
        persona2.presentacion()
        persona3.presentacion()
        persona4.presentacion()
    }

    class Persona(private val data: PersonData) {
        private val tag = ":::PERSON"

        fun presentacion() {
            Log.d(tag, "Me llamo ${data.name} y tengo ${data.age} años")
        }
    }

    data class PersonData (
        val name: String?,
        val age: Int?,
        val birthYear: Int,
    )

    private fun interfaces() {
        val rodrigoData = PersonData("Rodrigo", 27, 1994)
        val paketeData = PersonData("Pakete", 26, 1995)
        val edulioData = PersonData("Edulio", 26, 1995)
        val buleteData = PersonData("Bulete", 26, 1995)
        val manolitaData = PersonData("Manolita", 24, 1997)

        val rodrigo = SegundaPersona(rodrigoData)
        val pakete = SegundaPersona(paketeData)
        val edulio = SegundaPersona(edulioData)
        val bulete = SegundaPersona(buleteData)
        val manolita = SegundaPersona(manolitaData)

        rodrigo.presentacion()
        pakete.presentacion()
        edulio.presentacion()
        bulete.presentacion()
        manolita.presentacion()
    }

    class SegundaPersona(private val data: PersonData) : PersonInterface {
        private val tag = ":::PERSON"

        fun presentacion() {
            Log.d(tag, "Me llamo ${data.name} y tengo ${data.age} años")
        }

        override fun returnAge(): Int = Calendar.getInstance().get(Calendar.YEAR) - data.birthYear
    }

    interface PersonInterface {
        fun returnAge(): Int
    }

    interface ProgrammerInterface {
        fun getProgrammerData() :ProgrammerData
    }
    data class ProgrammerData (
        val name: String,
        val age: Int,
        val language: String,
    )
    class Programmer(private val data: ProgrammerData) : ProgrammerInterface {
        private val tag = ":::PROGRAMMER"

        override fun getProgrammerData(): ProgrammerData = ProgrammerData(getName(), getAge(), getLanguage())

        private fun getName(): String {
            return data.name
        }
        private fun getAge(): Int{
            return data.age
        }
        private fun getLanguage(): String {
            return data.language
        }
    }

    fun reto(name: String, age: Int, language: String) {
        val programmerData = ProgrammerData(name, age, language)
        val programmer = Programmer(programmerData)
        Log.d(tag, programmer.getProgrammerData().toString())
    }

}

