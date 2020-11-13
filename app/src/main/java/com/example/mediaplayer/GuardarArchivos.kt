package com.example.mediaplayer

import androidx.core.net.toUri
import com.example.mediaplayer.Constant.allMediaList
import com.example.mediaplayer.Constant.videoExtensions
import java.io.File
import java.net.URI

class GuardarArchivos {

    val listaURI: ArrayList<URI> = ArrayList<URI>()
    var listaArchivos: ArrayList<File> = ArrayList<File>()

    fun cargarArchivos(directorio: File): ArrayList<URI>{

        if(directorio.isDirectory){
            for(archivo in directorio.list().size){
                if(archivo.isDirectory){
                    cargarArchivos(archivo)
                }else{
                    var URIArchivo: URI = listaURI.add(archivo.toUri())
                    for(extension: String in videoExtensions){
                        if(nombre.endsWith(extension)){
                            allMediaList.add(archivo)
                        }
                    }
                }
            }
        }
        return listaURI

    }

    private operator fun Int.iterator(): Iterator<File> {
        listaArchivos.add(index)
    }
}


