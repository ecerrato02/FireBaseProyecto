package com.example.firebaseproyecto

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exameneduardocerrato.Adapter.JuegosAdapter
import com.example.firebaseproyecto.Data.JuegosViewModel
import com.example.firebaseproyecto.databinding.FragmentJuegosBinding

class JuegosFragment : Fragment() {

    companion object {
        fun newInstance() = JuegosFragment()
    }

    private val viewModel: JuegosViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getJuegos()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val binding = FragmentJuegosBinding.inflate(inflater)

        viewModel.getJuegos()

        binding.juegosRecycler.layoutManager = GridLayoutManager(context, 2)


        binding.buttonActualitzar.setOnClickListener {
            findNavController().navigate(R.id.action_juegosFragment_to_actualizarJuegoFragment)
        }
        viewModel.juegos.observe(viewLifecycleOwner){
            val adapter = JuegosAdapter(viewModel.juegos.value!!)
            binding.juegosRecycler.adapter = adapter
        }
        return binding.root
    }
}