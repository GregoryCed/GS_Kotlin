package com.example.gregorycedraz_rm94404

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gregorycedraz_rm94404.ui.theme.GregoryCedraz_RM94404Theme
import com.example.gregorycedraz_rm94404.viewmodel.DicasAdapter
import com.example.gregorycedraz_rm94404.viewmodel.DicasViewModel
import com.example.gregorycedraz_rm94404.viewmodel.DicasViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DicasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "EcoDicas"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val dicasAdapter = DicasAdapter { dica ->
            viewModel.removeDica(dica)
        }

        recyclerView.adapter = dicasAdapter

        val button = findViewById<Button>(R.id.button)
        val titulo = findViewById<EditText>(R.id.editTextTitulo)
        val descricao = findViewById<EditText>(R.id.editTextDescricao)

        button.setOnClickListener {
            if (titulo.text.isEmpty() && descricao.text.isEmpty()) {
                titulo.error = "Preencha um valor"
                descricao.error = "Preencha um valor"
                return@setOnClickListener
            }

            viewModel.addDica(titulo.text.toString(), descricao.text.toString())
            titulo.text.clear()
            descricao.text.clear()
        }

        val viewModelFactory = DicasViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DicasViewModel::class.java)
        viewModel.dicasLiveData.observe(this) { dicas ->
            dicasAdapter.updateDicas(dicas)
        }
    }
}