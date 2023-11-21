package com.cibertec.cl_3.Restaurante

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cl_3.R

class RestauranteActivity: AppCompatActivity(), RestauranteAdapter.ItemClickListener
{
    private lateinit var viewModel: RestauranteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)


        viewModel = ViewModelProvider(this)[RestauranteViewModel::class.java]
        viewModel.getRestauranteFirestore()


        val recycleRestaurante = findViewById<RecyclerView>(R.id.recyclerRestaurante)
        val adapter= RestauranteAdapter(this)
        recycleRestaurante.adapter=adapter
        recycleRestaurante.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        viewModel.listRestaurantes?.observe(this){ pedidos->
            pedidos?.let{
                adapter.setrestaurante(pedidos)
            }

        }
    }

    override fun onItemClick(restaurante: RestauranteFirebase) {

        /*val intent = Intent(this, PedidosActivity::class.java)
        intent.putExtra("nombre", pedidos.nombre)
        intent.putExtra("categoria", pedidos.categoria)
        intent.putExtra("imagen", pedidos.imagen)
        startActivity(intent)
*/
    }
}
