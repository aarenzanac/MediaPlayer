package com.example.mediaplayer

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayArchivos= ArrayList<Archivo>()

        //Creo el array de tipo File con el contenido de la carpeta
        val f = File(Environment.DIRECTORY_MOVIES.toString() + "/peliculas/")

        //Creo el array de tipo File con el contenido de la carpeta
        val files: Array<File>? = f.listFiles()

        for (f in files!!) {
            //Sacamos del array files un fichero
            val file = f
            arrayArchivos.add(Archivo(f, 0))

        }
    }
}

