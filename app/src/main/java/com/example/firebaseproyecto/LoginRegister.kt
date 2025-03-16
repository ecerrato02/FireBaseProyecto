package com.example.firebaseproyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebaseproyecto.Data.LoginRegistreViewModel
import com.example.firebaseproyecto.databinding.FragmentLoginRegisterBinding


class LoginRegister : Fragment() {
    private val viewModel: LoginRegistreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginRegisterBinding.inflate(inflater)

        binding.botonInicioSesion.setOnClickListener{
            val correo = binding.campoCorreo.text.toString()
            val contrasena = binding.campoContrasena.text.toString()
            viewModel.verificarUsuario(correo, contrasena, requireContext(), findNavController())
        }

        binding.botonRegistrarse.setOnClickListener{
            val correo = binding.campoCorreo.text.toString()
            val contrasena = binding.campoContrasena.text.toString()
            viewModel.crearUsuario(correo, contrasena, requireContext())
        }
        return binding.root
    }
}