package com.example.firebaseproyecto.Data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class JuegosViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val _juegos = MutableLiveData<List<Juegos>>()
    val juegos: LiveData<List<Juegos>>
        get() = _juegos

    fun getJuegos(){
        var juegosTemp = mutableListOf<Juegos>()

        db.collection("Juegos").get().addOnSuccessListener { result ->
            for (document in result) {
                Log.d("WASAAAA", "BIEN BIEN BIEN Información del documento: ${document.data}")
                juegosTemp.add(
                    Juegos(
                        document.id,
                        document.data["nombre"] as String,
                        document.data["precio"].toString().toDouble()
                    )
                );
            }
        }.addOnCompleteListener { _juegos.value = juegosTemp }
    }
}