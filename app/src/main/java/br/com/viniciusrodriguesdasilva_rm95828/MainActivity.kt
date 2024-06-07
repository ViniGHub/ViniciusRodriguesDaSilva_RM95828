package br.com.viniciusrodriguesdasilva_rm95828

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.viniciusrodriguesdasilva_rm95828.ui.theme.ViniciusRodriguesDaSilva_RM95828Theme

class MainActivity : ComponentActivity() {

    private lateinit var praiasAdapter: PraiasAdapter
    private val praiaList = ArrayList<Praia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        praiasAdapter = PraiasAdapter(praiaList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = praiasAdapter

        val nomePraia = findViewById<EditText>(R.id.NomePraia)
        val cidadePraia = findViewById<EditText>(R.id.CidadePraia)
        val estadoPraia = findViewById<EditText>(R.id.EstadoPraia)
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val btnIntegrantes = findViewById<Button>(R.id.btnIntegrantes)

        btnAdicionar.setOnClickListener {
            adicionarPraia()
        }

        btnIntegrantes.setOnClickListener {
            val intent = Intent(this, GroupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun adicionarPraia() {

        val nomePraia = findViewById<EditText>(R.id.NomePraia)
        val cidadePraia = findViewById<EditText>(R.id.CidadePraia)
        val estadoPraia = findViewById<EditText>(R.id.EstadoPraia)


        if (TextUtils.isEmpty(nomePraia.text) || TextUtils.isEmpty(cidadePraia.text) || TextUtils.isEmpty(estadoPraia.text)) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (nomePraia.text.length < 3 || cidadePraia.text.length < 3 || estadoPraia.text.length < 2) {
            Toast.makeText(this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show()
            return
        }

        val praia = Praia(nomePraia.text.toString(), cidadePraia.text.toString(), estadoPraia.text.toString())
        praiaList.add(praia)
        praiasAdapter.notifyDataSetChanged()

        nomePraia.text.clear()
        cidadePraia.text.clear()
        estadoPraia.text.clear()
    }

    fun removeBeach(position: Int) {
        praiaList.removeAt(position)
        praiasAdapter.notifyItemRemoved(position)
    }
}
