package com.example.firebaseproyecto

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebaseproyecto.Data.CrearJuegoViewModel
import com.example.firebaseproyecto.databinding.FragmentCrearJuegoBinding
import com.example.firebaseproyecto.databinding.FragmentLoginRegisterBinding

class CrearJuegoFragment : Fragment() {

    companion object {
        fun newInstance() = CrearJuegoFragment()
    }

    private val viewModel: CrearJuegoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCrearJuegoBinding.inflate(inflater)

        binding.crearJuego.setOnClickListener(){
            val nombre = binding.nombreJuego.text.toString()
            val precio = binding.precioJuego.text.toString().toDouble()
            viewModel.crearJuego(nombre, precio, findNavController())
        }
        return binding.root
    }
}