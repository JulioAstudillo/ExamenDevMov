package com.example.examendevmov

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examendevmov.databinding.ItemLibroBinding

class LibroAdapter(
    val listaLibros: List<Libro>,
    val libroDestacado: String?,
    val alClickear: (Libro) -> Unit
) : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {

    class LibroViewHolder(val binding: ItemLibroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding = ItemLibroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LibroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = listaLibros[position]

        holder.binding.txtTitulo.text = libro.titulo
        holder.binding.txtAutor.text = libro.autor
        holder.binding.txtAnio.text = libro.anio.toString()

        // Resaltar el libro destacado
        if (libro.titulo == libroDestacado) {
            holder.binding.cardLibro.setCardBackgroundColor(Color.parseColor("#FFD700"))
        } else {
            holder.binding.cardLibro.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        holder.binding.root.setOnClickListener {
            alClickear(libro)
        }
    }

    override fun getItemCount(): Int = listaLibros.size
}
