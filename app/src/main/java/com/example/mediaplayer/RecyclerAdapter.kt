package com.example.mediaplayer

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.Constant.allMediaList
import java.io.File


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var peliculas: MutableList<File>  = ArrayList()
    lateinit var context:Context
    lateinit var uri: Uri

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         uri = Uri.fromFile(allMediaList.get(position))

        holder.bind(uri)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.template_reyclerview, parent, false))
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var videoViewPelicula: VideoView = R.id.videoViewPelicula as VideoView
        var textViewPelicula: TextView = R.id.textViewPelicula as TextView


        fun bind(pelicula: Uri){
            videoViewPelicula.setVideoURI(pelicula)
            textViewPelicula.text = pelicula.toString()




            view.setOnClickListener(View.OnClickListener {
                videoViewPelicula.start()
                val mediaController = MediaController(view.context)
                videoViewPelicula.setMediaController(mediaController)
                /*Toast.makeText(
                        view.context,

                        Toast.LENGTH_SHORT
                ).show()*/
            })
        }
    }
}