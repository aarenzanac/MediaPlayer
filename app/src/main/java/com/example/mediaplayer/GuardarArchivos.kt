package com.example.mediaplayer

import com.example.mediaplayer.Constant.allMediaList
import com.example.mediaplayer.Constant.videoExtensions
import java.io.File

class GuardarArchivos {
    fun cargarArchivos(): Array<File>{
        var listaArchivos: File = File(R.raw.coffe)


        /*if(listaArchivos != null){
            for(archivo in listaArchivos){
                if(archivo.isDirectory){
                    cargarArchivos(archivo)
                }else{
                    var nombre: String = archivo.name.toLowerCase()
                    for(extension: String in videoExtensions){
                        if(nombre.endsWith(extension)){
                            allMediaList.add(archivo)
                        }
                    }
                }
            }
        }*/
        return listaArchivos

    }
}