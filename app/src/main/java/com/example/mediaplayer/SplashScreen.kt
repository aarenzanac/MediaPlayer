package com.example.mediaplayer

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.webkit.PermissionRequest
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File


class SplashScreen : AppCompatActivity() {

    //var directorioRaw: File = File("C:\\Users\\USUARIO\\AndroidStudioProjects\\MediaPlayer\\app\\src\\main\\res\\raw")
    var guardarArchivos: GuardarArchivos = GuardarArchivos()
    public override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.splash_screen_layout)

        //CARGO LAS PELICULAS
        var listaArchivos: Array<File> = guardarArchivos.cargarArchivos()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("arrayArchivos", listaArchivos)
        startActivity(intent)
    }
}