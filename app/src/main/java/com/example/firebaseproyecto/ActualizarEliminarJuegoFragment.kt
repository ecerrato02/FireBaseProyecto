package com.example.firebaseproyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebaseproyecto.Data.ActualizarEliminarViewModel
import com.example.firebaseproyecto.Data.Juegos
import com.example.firebaseproyecto.databinding.FragmentActualizarJuegoBinding

class ActualizarEliminarJuegoFragment : Fragment() {
    companion object{
        fun newInstance() = ActualizarEliminarJuegoFragment()
    }
    private val viewModel: ActualizarEliminarViewModel by viewModels()
    private val selectedJuego: Juegos = ActualizarEliminarViewModel.selectedJuego

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActualizarJuegoBinding.inflate(inflater)

        binding.nombreJuego.setText(selectedJuego.nombre)
        binding.precioJuego.setText(selectedJuego.precio.toString())

        binding.actualizarJuego.setOnClickListener(){
            var nombre = binding.nombreJuego.text.toString()
            var precio = binding.precioJuego.text.toString().toDouble()
            viewModel.actualizarJuego(findNavController(), nombre, precio)
        }

        binding.eliminarJugeo.setOnClickListener(){
            viewModel.eliminarJuego(findNavController())
        }

        binding.buttonJuegos.setOnClickListener {
            findNavController().navigate(R.id.juegosFragment)
        }
        return binding.root
    }
}