package com.example.firebaseproyecto.Data

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.firebaseproyecto.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginRegistreViewModel: ViewModel() {

    private lateinit var auth: FirebaseAuth

    fun crearUsuario(correo: String, contrasena: String, ctx: Context) {
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.d("FIREBASE BIEN", "Usuario creado exitosamente")
                    Toast.makeText(ctx, "Usuario creado exitosamente", Toast.LENGTH_LONG).show()
                } else {
                    Log.e("FIREBASERROR", "Error al crear usuario", task.exception)
                    Toast.makeText(ctx, "Error: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun verificarUsuario(correo: String, contrasena: String, ctx: Context, navigation: NavController){
        auth = Firebase.auth
        auth.signInWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.d("INICO SESIÓN BIEN", "signInWithEmail:success")
                    Toast.makeText(ctx, "Sesión iniciada, " + correo, Toast.LENGTH_SHORT,).show()
                    navigation.navigate(R.id.action_loginRegister_to_juegosFragment)
                } else {
                    Log.w("INICIO SESIÓN ERROR", "Error al iniciar sesión", task.exception)
                    Toast.makeText(ctx, "Fallo al verificar", Toast.LENGTH_SHORT,).show()
                }
            }
    }
}