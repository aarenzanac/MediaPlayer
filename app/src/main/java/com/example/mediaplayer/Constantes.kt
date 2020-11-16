package com.example.mediaplayer

import java.io.File

object Constant {

    //LISTADO DE EXTENSIONES PARA COMPRAR LOS ARCHIVOS DEL DIRECTORIO Y VER SI SON DE VIDEO
    var videoExtensions1 = arrayOf(".mp4", ".ts", ".mkv", ".mov",
            ".3gp", ".mv2", ".m4v", ".webm", ".mpeg1", ".mpeg2", ".mts", ".ogm",
            ".bup", ".dv", ".flv", ".m1v", ".m2ts", ".mpeg4", ".vlc", ".3g2",
            ".avi", ".mpeg", ".mpg", ".wmv", ".asf")
    var videoExtensions = arrayOf(".mp4", ".ts")

    //LISTA DE TODOS LOS ARCHIVOS VIDEO QUE SE HAN AÑADIDO TRAS COMPARARLOS Y COINCIDIR CON LAS EXTENSIONES ANTERIORESE
    var listadoArchivosVideo: ArrayList<File>? = ArrayList()
}