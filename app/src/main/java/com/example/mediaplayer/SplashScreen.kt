package com.example.mediaplayer


import android.content.Intent
import android.os.Bundle
import android.os.storage.StorageManager
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class SplashScreen : AppCompatActivity() {

    private lateinit var almacenamiento: File
    private lateinit var pathsAlmacenamiento: ArrayList<String>
    var guardarArchivos: GuardarArchivos = GuardarArchivos()
    public override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.splash_screen_layout)

        pathsAlmacenamiento =


        for(path: String in pathsAlmacenamiento){
            almacenamiento = File(path)
            guardarArchivos.cargarArchivos(almacenamiento)
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}