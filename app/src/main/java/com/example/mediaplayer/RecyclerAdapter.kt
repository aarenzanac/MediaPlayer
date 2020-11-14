package com.example.mediaplayer

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.Constant.allMediaList
import java.io.File


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(allMediaList?.get(position)!!)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.template_reyclerview, parent, false)
        return ViewHolder(layoutInflater)

    }

    override fun getItemCount(): Int {
        return allMediaList?.size!!
    }


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var videoViewPelicula = view.findViewById(R.id.videoViewPelicula) as VideoView
        private var textViewPelicula = view.findViewById(R.id.textViewPelicula) as TextView
        private lateinit var mediaPlayer: MediaPlayer


        fun bind(pelicula: File){
            videoViewPelicula.setVideoURI(Uri.fromFile(pelicula))
            textViewPelicula.text = pelicula.name




            view.setOnClickListener(View.OnClickListener {
                Toast.makeText(view.context, pelicula.name, Toast.LENGTH_SHORT).show()})

            val botonPlay = view.findViewById(R.id.imageViewPlay) as ImageView
            val botonPause = view.findViewById(R.id.imageViewPause) as ImageView
            val botonStop = view.findViewById(R.id.imageViewStop) as ImageView


            botonPlay.setOnClickListener {
                videoViewPelicula.start()
            }
            botonPause.setOnClickListener {
                videoViewPelicula.pause()
            }
            botonStop.setOnClickListener {
                videoViewPelicula.stopPlayback()
                videoViewPelicula.resume()
                videoViewPelicula.setVideoURI(Uri.fromFile(pelicula))
            }
        }
    }
}