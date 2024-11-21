package cr.ac.utn.GreenHabits


import CustomAdapter
import android.Manifest
import android.app.Activity
import android.app.ListActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StatsActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtLastName: EditText
    private lateinit var txtPhone: EditText
    private lateinit var txtEmail: EditText
    private lateinit var imgPhoto: ImageView
    private lateinit var datosDBHelper: MiSQLiteHelper
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        // Referencias de vistas
        txtName = findViewById(R.id.Cen_txtName)
        txtLastName = findViewById(R.id.Cen_txtLastName)
        txtPhone = findViewById(R.id.Cen_txtPhone)
        txtEmail = findViewById(R.id.Cen_txtEmail)
        imgPhoto = findViewById(R.id.Cen_imagen_view)

        datosDBHelper = MiSQLiteHelper(this)

        imgPhoto.setOnClickListener {
            showImageSourceDialog()
        }
    }

    private fun showImageSourceDialog() {
        val options = arrayOf("Tomar foto", "Seleccionar de galería")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Seleccionar fuente de imagen")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> openCamera()
                1 -> openGallery()
            }
        }
        builder.show()
    }

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                imgPhoto.setImageURI(imageUri)
            }
        }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                imageUri = it
                imgPhoto.setImageURI(it)
            }
        }

    private fun openCamera() {
        val hasCameraPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

        if (hasCameraPermission) {
            val uri = FileProviderHelper.createImageFileUri(this) // Puede ser nulo
            if (uri != null) {
                imageUri = uri // Asigna a tu variable global
                cameraLauncher.launch(imageUri!!)
            } else {
                Toast.makeText(this, "Error al crear archivo para la imagen.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openGallery() {
        galleryLauncher.launch("image/*")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.cen_crud_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Cen_mn_save -> {
                val name = txtName.text.toString()
                val lastName = txtLastName.text.toString()
                val phone = txtPhone.text.toString()
                val email = txtEmail.text.toString()

                if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || imageUri == null) {
                    Toast.makeText(this, "Por favor, llene todos los campos.", Toast.LENGTH_SHORT).show()
                } else {
                    val result = datosDBHelper.addDate(
                        name,
                        lastName,
                        phone,
                        email,
                        imageUri.toString()
                    )
                    if (result > 0) {
                        Toast.makeText(this, "Datos guardados correctamente.", Toast.LENGTH_SHORT).show()

                        // Aquí puedes enviar los datos a DetailsActivity
                        val intent = Intent(this, DetailsActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Error al guardar los datos.", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

















