package br.com.viniciusrodriguesdasilva_rm95828

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class GroupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}