package com.example.mediaplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {

    //private var paths: Array<String> = TODO()
    //var guardarArchivos: GuardarArchivos = GuardarArchivos()
    public override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.splash_screen_layout)
/*
        //CARGO LAS PELICULAS
        paths = filesDir.list()

        for (path in paths) {
            var almacenamiento = File(path)
           guardarArchivos.cargarArchivos(almacenamiento)
        }*/
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}