package com.cibertec.cl_3.Restaurante

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cl_3.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RestauranteViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_restaurante, parent,
        false))
{
    private var imagen: ImageView? = null
    private var textTitulo: TextView? = null
    private var textDescripcion: TextView? = null

    init {
        imagen = itemView.findViewById(R.id.imagen)
        textTitulo = itemView.findViewById(R.id.textTitulo)
        textDescripcion = itemView.findViewById(R.id.textDescripcion)
    }


    fun bind(restaurante: RestauranteFirebase) {
        textTitulo?.text = restaurante.titulo
        textDescripcion?.text = restaurante.descripcion

        val options = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        imagen?.let {
            Glide.with(it)
                .setDefaultRequestOptions(options)
                .load(restaurante.imagen)
                .into(it)
        }
    }
}