package com.example.examendevmov


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examendevmov.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding
    private var tituloLibro: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obtenerDatos()
        configurarBoton()
    }

    fun obtenerDatos() {
        tituloLibro = intent.getStringExtra("titulo")
        val autor = intent.getStringExtra("autor")
        val anio = intent.getIntExtra("anio", 0)

        binding.txtDetalTitulo.text = tituloLibro
        binding.txtDetalAutor.text = autor
        binding.txtDetalAnio.text = anio.toString()
    }

    fun configurarBoton() {
        binding.btnGuardar.setOnClickListener {
            guardarEnPreferencias()
        }
    }

    fun guardarEnPreferencias() {
        val preferencias = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        val editor = preferencias.edit()
        editor.putString("libro_destacado", tituloLibro)
        editor.apply()

        Toast.makeText(this, "Libro guardado como destacado", Toast.LENGTH_SHORT).show()
    }
}
