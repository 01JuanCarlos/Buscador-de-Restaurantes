package com.cibertec.cl_3.Restaurante

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter (val mItemClickListener: ItemClickListener):
    RecyclerView.Adapter<RestauranteViewHolder>()
{
    private var RestauranteList = emptyList<RestauranteFirebase>()


    fun setrestaurante(restaurante:List<RestauranteFirebase>){
        this.RestauranteList=restaurante
        this.notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RestauranteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RestauranteViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return RestauranteList.size
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restaurante: RestauranteFirebase = RestauranteList[position]
        holder.bind(restaurante)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(restaurante)
        }
    }


    interface ItemClickListener{
        fun onItemClick(restaurante: RestauranteFirebase)
    }
}