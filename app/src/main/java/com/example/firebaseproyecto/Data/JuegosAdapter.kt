package com.example.exameneduardocerrato.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseproyecto.Data.Juegos
import com.example.firebaseproyecto.R

class JuegosAdapter(private val mList: List<Juegos>) : RecyclerView.Adapter<JuegosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.juegos_card_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val juego = mList[position]

        holder.textViewNom.text = juego.nombre
        holder.textViewEdat.text = juego.precio.toString()

        holder.layoutPulsar.setOnClickListener{view ->
            view.findNavController().navigate(R.id.actualizarJuegoFragment)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.nombreJuego)
        val textViewEdat: TextView = itemView.findViewById(R.id.precioJuego)
        val layoutPulsar: LinearLayout = itemView.findViewById(R.id.layoutJuegos)
    }
}