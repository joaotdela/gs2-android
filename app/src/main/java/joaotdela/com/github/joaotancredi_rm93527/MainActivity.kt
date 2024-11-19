package joaotdela.com.github.joaotancredi_rm93527

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import joaotdela.com.github.joaotancredi_rm93527.viewmodel.DicaAdapter
import joaotdela.com.github.joaotancredi_rm93527.viewmodel.DicaViewModel
import joaotdela.com.github.joaotancredi_rm93527.viewmodel.DicaViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var dicaViewModel: DicaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.dicaRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DicaAdapter(mutableListOf()) { dica ->
            Toast.makeText(this, "Dica: ${dica.title}", Toast.LENGTH_SHORT).show()
        }

        val button = findViewById<Button>(R.id.pageButton)
        button.setOnClickListener {
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val viewModelFactory = DicaViewModelFactory(application)

        dicaViewModel = ViewModelProvider(this, viewModelFactory).get(DicaViewModel::class.java)

        dicaViewModel.dicas.observe(this) { items ->
            adapter.updateDicas(items)
        }

        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let{
                    dicaViewModel.searchDicas(it).observe(this@MainActivity){ dicasFiltradas ->
                        adapter.updateDicas(dicasFiltradas)
                    }
                }
                return true
            }
        })

    }


}