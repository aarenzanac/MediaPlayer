package com.example.mediaplayer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class VideoViewFullScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view_full_screen)

        val intent: Intent = intent
        var pelicula: String? = intent.getStringExtra("uri")
        var uriPelicula: Uri? = pelicula!!.toUri()

        var videoFullScreen = findViewById(R.id.vieoViewFullScreen) as VideoView
        var mediaController: MediaController = MediaController(this)

        videoFullScreen.setVideoURI(uriPelicula)
        videoFullScreen.setMediaController(mediaController)

    }
}