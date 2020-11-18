package com.example.mediaplayer

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {

    private var adapter:RecyclerAdapter = RecyclerAdapter()
    private val pathAlmacenamientoInterno = File("/storage/emulated/0/")
    private val pathAlmacenamientoExtraible = File("storage/emulated/")
    private var unidadSeleccionada: Int = 0
    private var cargarArchivos: GuardarArchivos = GuardarArchivos()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CREO EL IDENTIFICADOR DEL RECYCLER Y LO INICIO
        var recyclerView: RecyclerView  = findViewById(R.id.recyclerView)
        inicializarRecycler(recyclerView)

        //CREO EL SPINNER CON LAS UNIDADES DESDE EL XML UNIDADES DE ALMACENAMIENTO
        val spinnerUnidades: Spinner = findViewById<Spinner>(R.id.spinnerUnidades)
        val spinnerAdapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.unidadesAlmacenamiento, android.R.layout.simple_spinner_dropdown_item)

        var unidadSeleccionada: Int = spinnerUnidades.selectedItemPosition
        spinnerUnidades.adapter = spinnerAdapter

        val botonCargar: Button = findViewById(R.id.buttonCargar)


        //CARGA LAS PELÍCULAS EN FUNCIÓN DE LA UNIDAD SELECCIONADA
        botonCargar.setOnClickListener {
            unidadSeleccionada = spinnerUnidades.selectedItemPosition

            when(unidadSeleccionada){
                0 -> { Toast.makeText(this, "DEBE SELECCIONAR UNA UNIDAD", Toast.LENGTH_SHORT).show()}

                1 -> {Constant.listadoArchivosVideo?.clear()
                    cargarArchivos.cargarArchivos(pathAlmacenamientoInterno)
                    inicializarRecycler(recyclerView)
                }

                2 -> {Constant.listadoArchivosVideo?.clear()
                    cargarArchivos.cargarArchivos(pathAlmacenamientoExtraible)
                    inicializarRecycler(recyclerView)
                }
            }

        }

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



