package cr.ac.utn.GreenHabits

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MiSQLiteHelper(context: Context) : SQLiteOpenHelper(context, "Datos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE datos (
                _id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                last_name TEXT,
                phone TEXT,
                email TEXT,
                image_uri TEXT
            )
        """
        db!!.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS datos")
        onCreate(db)
    }

    fun addDate(name: String, lastName: String, phone: String, email: String, imageUri: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("last_name", lastName)
        values.put("phone", phone)
        values.put("email", email)
        values.put("image_uri", imageUri)
        val result = db.insert("datos", null, values)
        db.close()
        return result
    }

    fun getAllData(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM datos", null)
    }
}
