package com.example.mediaplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intent: Intent = intent
        val listaArchivos = getIntent().getSerializableExtra("arrayArchivos") as Array<File>?
        inicializarRecycler(listaArchivos)

    }

    fun inicializarRecycler(listaArchivos: Array<File>?){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
        recyclerView.isNestedScrollingEnabled = false

        val adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

    }
}

