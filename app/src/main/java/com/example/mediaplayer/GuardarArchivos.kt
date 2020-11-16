package com.example.mediaplayer

import com.example.mediaplayer.Constant.listadoArchivosVideo
import com.example.mediaplayer.Constant.videoExtensions
import java.io.File

class GuardarArchivos {

    //FUNCIÓN QUE RECORRE LOS DIFERENTES DIRECTORIOS. SI ENCUENTRA OTRO DIRECTORIO, SE VUELVE A LLAMAR Y SI ENCUENTRA ARCHIVOS LOS RECORRE
    //COMPARANDOLOS CON LAS EXTENSIONES. SI COINCIDE CON LAS EXTENSIONES, LO AÑADE AL LISTADO LISTADOARCHIVOSVIDEO.
    fun cargarArchivos(directorio: File){
        var listado: Array<File>?
        listado = directorio.listFiles()

        if(listado != null && listado.size > 0) {
            for (file: File in listado) {
                if (file.isDirectory) {
                    cargarArchivos(file)
                } else {
                    var nombre: String = file.name.toLowerCase()
                    for (extension: String in videoExtensions) {
                        if (nombre.endsWith(extension)) {
                            listadoArchivosVideo?.add(file)
                        }
                    }
                }
            }
        }
    }
}


