package com.example.mediaplayer

import com.example.mediaplayer.Constant.allMediaList
import com.example.mediaplayer.Constant.videoExtensions
import java.io.File

class GuardarArchivos {


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


