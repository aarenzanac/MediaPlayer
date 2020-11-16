package com.example.mediaplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var adapter:RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CREO EL IDENTIFICADOR DEL RECYCLER Y LO INICIO
        var recyclerView: RecyclerView  = findViewById(R.id.recyclerView)
        inicializarRecycler(recyclerView)



    }

    //FUNCIÓN PARA INICIAR EL RECYCLER
    private fun inicializarRecycler(recyclerView: RecyclerView){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
        recyclerView.isNestedScrollingEnabled = false

        //LE ASIGNO EL ADAPTADOR QUE LO RELLENARÁ
        recyclerView.adapter = adapter

    }
}



