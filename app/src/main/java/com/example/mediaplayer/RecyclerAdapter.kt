package com.example.mediaplayer

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var peliculas: MutableList<Pelicula>  = ArrayList()
    lateinit var context:Context

    fun RecyclerAdapter(peliculas: MutableList<Pelicula>, context: Context){
        this.peliculas = peliculas
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var uri: Uri = Uri.fromFile(Constant.allMediaList.get(position));

        val item = peliculas.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.template_reyclerview, parent, false))
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var pelicula = view.findViewById(R.id.videoViewPelicula) as VideoView
        var titulo = view.findViewById(R.id.textViewPelicula) as TextView


        fun bind(objetoPelicula: Pelicula, context: Context){
            titulo.text = objetoPelicula.titulo
            pelicula = objetoPelicula.video



            itemView.setOnClickListener(View.OnClickListener {
                pelicula.start()
                val mediaController = MediaController(context)
                pelicula.setMediaController(mediaController)
                Toast.makeText(
                    context,
                    objetoPelicula.titulo,
                    Toast.LENGTH_SHORT
                ).show()
            })


        }
        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }

}



/*class MyAdapter(private val myDataset: Array<Pelicula>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.

    class MyViewHolder(var video: VideoView, var titulo: TextView ) : RecyclerView.ViewHolder(video, titulo)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        var video = LayoutInflater.from(parent.context)
                .inflate(R.layout.template_reyclerview, parent, false) as VideoView
        var titulo = LayoutInflater.from(parent.context)
                .inflate(R.layout.template_reyclerview, parent, false) as TextView

        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(video, titulo)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.titulo = myDataset[position]
        holder.video = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}*/
