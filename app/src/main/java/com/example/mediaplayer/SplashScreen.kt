package com.example.mediaplayer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.security.Guard


class SplashScreen(var context: Context) : AppCompatActivity() {
    private var directorioAlmacenamiento: File? = null
    private var paths: Array<String> = TODO()
    public override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        //load data here
        paths = context.filesDir.list()
        //paths = context.getDir(raw, Context.MODE_PRIVATE)
        for (path in paths) {
           GuardarArchivos.
        }
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
    }
}