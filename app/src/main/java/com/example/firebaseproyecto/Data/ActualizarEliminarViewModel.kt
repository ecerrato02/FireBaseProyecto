package com.example.firebaseproyecto.Data

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.firebaseproyecto.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ActualizarEliminarViewModel:  ViewModel(){
    val db = Firebase.firestore

    companion object {
       var selectedJuego: Juegos = Juegos("a", "a", 0.00)

        fun selectJuego(juego: Juegos){
            selectedJuego = juego
        }
    }

    fun actualizarJuego(nav: NavController, nombre: String, precio: Double){
        db.collection("Juegos").document(selectedJuego.id).update(mapOf("nombre" to nombre, "precio" to precio)).addOnSuccessListener{
            nav.navigate(R.id.action_actualizarJuegoFragment_to_juegosFragment)
        }
    }

    fun eliminarJuego(nav: NavController){
        db.collection("Juegos").document(selectedJuego.id).delete().addOnSuccessListener {
            nav.navigate(R.id.action_actualizarJuegoFragment_to_juegosFragment)
        }
    }
}