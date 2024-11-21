import android.database.Cursor
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cr.ac.utn.GreenHabits.R

class CustomAdapter(private var cursor: Cursor) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Método para actualizar el cursor con nuevos datos
    fun updateCursor(newCursor: Cursor) {
        cursor.close()  // Cierra el cursor anterior
        cursor = newCursor  // Asigna el nuevo cursor
        notifyDataSetChanged()  // Notifica al adaptador para que actualice la lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (cursor.moveToPosition(position)) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val lastname = cursor.getString(cursor.getColumnIndexOrThrow("last_name"))
            val phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val imageUri = cursor.getString(cursor.getColumnIndexOrThrow("image_uri")) // URI de la imagen

            holder.nameTextView.text = name
            holder.lastNameTextView.text = lastname
            holder.phone.text = phone
            holder.email.text = email
            if (imageUri != null) {
                holder.imageView.setImageURI(Uri.parse(imageUri)) // Usamos el URI guardado
            } else {
                holder.imageView.setImageResource(0) // Si no hay URI, mostramos un placeholder
            }
        }
    }

    override fun getItemCount(): Int = cursor.count

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val lastNameTextView:TextView = itemView.findViewById(R.id.lastNameTextView)
        val phone:TextView = itemView.findViewById(R.id.phoneTextView)
        val email:TextView = itemView.findViewById(R.id.emailTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}



