package com.example.firebaseproyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebaseproyecto.databinding.FragmentActualizarJuegoBinding
import com.example.firebaseproyecto.databinding.FragmentLoginRegisterBinding

class ActualizarJuegoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActualizarJuegoBinding.inflate(inflater)

        binding.buttonJuegos.setOnClickListener {
            findNavController().navigate(R.id.juegosFragment)
        }
        return binding.root
    }
}