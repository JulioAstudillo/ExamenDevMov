package com.example.examendevmov

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examendevmov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listaLibros = mutableListOf<Libro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        crearListaLibros()
        configurarRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        configurarRecyclerView()
    }

    fun crearListaLibros() {
        listaLibros.add(Libro("Cien años de soledad", "Gabriel García Márquez", 1967))
        listaLibros.add(Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605))
        listaLibros.add(Libro("1984", "George Orwell", 1949))
        listaLibros.add(Libro("El principito", "Antoine de Saint-Exupéry", 1943))
        listaLibros.add(Libro("Orgullo y prejuicio", "Jane Austen", 1813))
        listaLibros.add(Libro("Rayuela", "Julio Cortázar", 1963))
        listaLibros.add(Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001))
        listaLibros.add(Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 1981))
        listaLibros.add(Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", 1985))
        listaLibros.add(Libro("Los detectives salvajes", "Roberto Bolaño", 1998))
    }

    fun configurarRecyclerView() {
        val preferencias = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        val libroDestacado = preferencias.getString("libro_destacado", null)

        val adaptador = LibroAdapter(listaLibros, libroDestacado) { libro ->
            abrirDetalle(libro)
        }

        binding.recyclerLibros.layoutManager = LinearLayoutManager(this)
        binding.recyclerLibros.adapter = adaptador
    }

    fun abrirDetalle(libro: Libro) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("titulo", libro.titulo)
        intent.putExtra("autor", libro.autor)
        intent.putExtra("anio", libro.anio)
        startActivity(intent)
    }
}
