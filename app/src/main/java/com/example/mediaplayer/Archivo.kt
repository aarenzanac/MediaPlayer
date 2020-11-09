package com.example.mediaplayer

import java.io.File

class Archivo {

    class Archivo(nombre: File, icono: Int){

        var nombre: File
        var icono: Int = 0


        constructor(nombre : File, icono: Int) {
            this.nombre = nombre
            this.icono = icono

        }

    }
}