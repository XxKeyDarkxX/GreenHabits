package cr.ac.utn.GreenHabits

import CustomAdapter
import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cr.ac.utn.GreenHabits.MiSQLiteHelper
import cr.ac.utn.GreenHabits.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var datosDBHelper: MiSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializar el helper de base de datos
        datosDBHelper = MiSQLiteHelper(this)

        // Obtener todos los datos
        val cursor = datosDBHelper.getAllData()

        // Configurar el adaptador
        customAdapter = CustomAdapter(cursor)
        recyclerView.adapter = customAdapter
    }
}


