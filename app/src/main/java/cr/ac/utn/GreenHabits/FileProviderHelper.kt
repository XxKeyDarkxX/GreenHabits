package cr.ac.utn.GreenHabits

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileProviderHelper {
    fun createImageFileUri(context: Context): Uri? {
        // Crear un archivo temporal en el directorio externo
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val tempFile = File.createTempFile("IMG_${timeStamp}_", ".jpg", storageDir)

        // Devolver un URI válido usando el FileProvider
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            tempFile
        )
    }
}
