package com.example.firebaseproyecto.Data

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.firebaseproyecto.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class CrearJuegoViewModel : ViewModel() {

    val db = Firebase.firestore

    fun crearJuego(nombre: String, precio: Double, navigator: NavController){
        val juego = hashMapOf("nombre" to nombre, "precio" to precio)
        db.collection("Juegos").add(juego).addOnSuccessListener {
            navigator.navigate(R.id.action_crearJuegoFragment_to_juegosFragment)
        }
    }
}