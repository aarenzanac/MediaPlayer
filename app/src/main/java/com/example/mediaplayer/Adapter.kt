package com.example.mediaplayer

/*
class Adapter(var context: Context, items: ArrayList<Archivo>): BaseAdapter(){

    //CREO EL ARRAY QUE CONTENDRÁ LOS OBJETOS DE TIPO ARCHIVO
    var items: ArrayList<Archivo>? = null

    //CONSTRUCTOR
    init{
        this.items = items
    }

    //IMPLEMENTO LOS MÉTODOS QUE OBLIGA A RECARGAR AL HEREDAR DE BASEADAPTER
    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(posicion: Int): Any {
        return items?.get(posicion)!!
    }

    override fun getItemId(posicion: Int): Long {
        return posicion.toLong()
    }

    override fun getView(posicion: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        var holder: ViewHolder?

        //SI LA VISTA ESTA VACÍA, QUE LA CREE
        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template_listview, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as? ViewHolder
        }
        val item = items?.get(posicion)

        //RELLENA LA VISTA
        holder?.nombre?.text = item?.nombre
        holder?.imagen?.setImageResource(item?.icono!!)

        return vista!!

    }

    private class ViewHolder(vista: View){
        var nombre: TextView? = null
        var imagen: ImageView? = null

        init{
            nombre = vista.findViewById(R.id.textViewMedida)
            imagen = vista.findViewById(R.id.imageViewMedida)
        }
    }

    }
}*/