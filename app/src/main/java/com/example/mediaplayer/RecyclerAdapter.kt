package com.example.mediaplayer

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.Constant.listadoArchivosVideo
import java.io.File


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //CREA EL ITEM
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(listadoArchivosVideo?.get(position)!!)
    }

    //PINTA EL ITEM MEDIANTE EL VIEWHOLDER
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.template_reyclerview, parent, false)
        return ViewHolder(layoutInflater)

    }

    //CUENTA LOS ITEMS QUE TENDRÁ QUE PINTAR
    override fun getItemCount(): Int {
        return listadoArchivosVideo?.size!!
    }


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var videoViewPelicula = view.findViewById(R.id.videoViewPelicula) as VideoView
        private var textViewPelicula = view.findViewById(R.id.textViewPelicula) as TextView
        //private lateinit var mediaPlayer: MediaPlayer

        //ASIGNA LOS DIFERENTES ELEMENTOS A CADA CAMPO DE CADA ITEM
        fun bind(pelicula: File) {
            videoViewPelicula.setVideoURI(Uri.fromFile(pelicula))

            textViewPelicula.text = pelicula.name

            //ACCION CUANDO SE PULSA EN EL ITEM
            var cardViewPelicula = view.findViewById(R.id.carViewPelicula) as CardView

            cardViewPelicula.setOnClickListener(View.OnClickListener {
                var intent: Intent = Intent(view.context, VideoViewFullScreen::class.java)
                intent.putExtra("uri", Uri.fromFile(pelicula).toString())
                startActivity(view.context, intent, null)

                Toast.makeText(view.context, pelicula.name, Toast.LENGTH_SHORT).show()
            }

            )
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