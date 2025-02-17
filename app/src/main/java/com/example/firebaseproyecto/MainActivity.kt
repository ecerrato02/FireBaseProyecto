package com.example.firebaseproyecto

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.firebaseproyecto.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.botonInicioSesion.setOnClickListener{
            val correo = binding.campoCorreo.text.toString()
            val contrasena = binding.campoContrasena.text.toString()
            verificarUsuario(correo, contrasena)
        }

        binding.botonRegistrarse.setOnClickListener{
            val correo = binding.campoCorreo.text.toString()
            val contrasena = binding.campoContrasena.text.toString()
            crearUsuario(correo, contrasena)
        }
    }

    private fun crearUsuario(correo: String, contrasena: String) {
        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("FirebaseAuth", "Usuario creado exitosamente")
                    Toast.makeText(baseContext, "Usuario creado exitosamente", Toast.LENGTH_LONG).show()
                } else {
                    Log.e("FirebaseAuth", "Error al crear usuario", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Error: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    private fun verificarUsuario(correo: String, contrasena: String){
        auth.signInWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        this,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
}