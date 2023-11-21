package com.cibertec.cl_3.Restaurante

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class RestauranteViewModel: ViewModel() {
    private lateinit var firestore: FirebaseFirestore

    val listRestaurantes = MutableLiveData<List<RestauranteFirebase>>()

    fun getRestauranteFirestore() {
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("Restaurantes").get()
            .addOnSuccessListener { documentList ->
                var listaRest = arrayListOf<RestauranteFirebase>()
                for (document in documentList) {
                    val titulo = document.getString("titulo")
                    val descripcion = document.getString("descripcion")
                    val imagen = document.getString("imagen")

                    if (titulo != null && descripcion != null && imagen != null) {
                        val restaurante =
                            RestauranteFirebase(titulo, descripcion, imagen)
                        listaRest.add(restaurante)
                    }
                }
                listRestaurantes.value = listaRest
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }
    }

}