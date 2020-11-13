package com.example.mediaplayer


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File


class SplashScreen : AppCompatActivity() {

    val permisos = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private var duracionSplashScreen: Long = 3000
    var guardarArchivos: GuardarArchivos = GuardarArchivos()

    private lateinit var almacenamiento: File
    private lateinit var pathsAlmacenamiento: Array<File?>

    public override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.splash_screen_layout)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, permisos, 121)
        }

        pathsAlmacenamiento = getExternalFilesDirs(Environment.getExternalStorageState())

        for(path: File? in pathsAlmacenamiento){
            almacenamiento = path!!
            guardarArchivos.cargarArchivos(almacenamiento)
        }


        Handler().postDelayed(Runnable
        //SE MUESTRA EL SPLASH SCREEN DURANTE EL TIEMPO ESTIPULADO EN LA VARIABLE duracionSplasScreen
        { // PASADO ESE TIEMPO, EJECUTA LA SIGUIENTE ACTIVIDAD
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, duracionSplashScreen)
    }
}