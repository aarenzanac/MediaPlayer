package com.example.mediaplayer

import androidx.core.net.toUri
import com.example.mediaplayer.Constant.allMediaList
import com.example.mediaplayer.Constant.videoExtensions
import java.io.File
import java.net.URI

class GuardarArchivos {

    val listaURI: ArrayList<URI> = ArrayList<URI>()
    var listaArchivos: ArrayList<File> = ArrayList<File>()

    fun cargarArchivos(directorio: File){
        var listado: Array<File> = directorio.listFiles()!!

        if(listado != null && listado.size > 0) {
            for (file: File in listado) {
                if (file.isDirectory) {
                    cargarArchivos(file)
                } else {
                    var nombre: String = file.name.toLowerCase()
                    for (extension: String in videoExtensions) {
                        if (nombre.endsWith(extension)) {
                            allMediaList.add(file)
                        }
                    }
                }
            }
        }
    }
}


