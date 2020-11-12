package com.example.mediaplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var peliculas: MutableList<Pelicula>  = ArrayList()
    lateinit var context:Context

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(peliculas[position])
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

        fun bind(objetoPelicula: Pelicula){
            videoViewPelicula = objetoPelicula.video
            textViewPelicula.text = objetoPelicula.titulo



            view.setOnClickListener(View.OnClickListener {
                videoViewPelicula.start()
                val mediaController = MediaController(view.context)
                videoViewPelicula.setMediaController(mediaController)
                Toast.makeText(
                        view.context,
                        objetoPelicula.titulo,
                        Toast.LENGTH_SHORT
                ).show()
            })
        }
    }
}