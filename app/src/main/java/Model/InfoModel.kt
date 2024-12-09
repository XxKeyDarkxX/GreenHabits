package Model

import Data.MemoryManager
import Entities.InfoPersonal
import Interface.IDBmanager
import android.content.Context
import cr.ac.utn.GreenHabits.R

class InfoModel {
    private var dbManager: IDBmanager = MemoryManager
    private lateinit var _context: Context

    constructor(context: Context) {
        _context = context
    }

    fun addContact(Info_perso: InfoPersonal) {
        dbManager.add(Info_perso)
    }

    fun getContacts() = dbManager.getAll()

    fun getContact(id: String): InfoPersonal? {
        var result = dbManager.getById(id)
        if (result == null) {
            val message = _context.getString(R.string.Green_Not_Found)
        }
        return result
    }

    fun getContactNames(): List<String> {
        val names = mutableListOf<String>()
        dbManager.getAll().forEach { i -> names.add(i.fullName) }
        return names.toList()
    }

    fun removeContact(id: String) {
        val result = dbManager.getById(id)
        if (result == null) {
            val message = _context.getString(R.string.Green_Not_Found)
            throw Exception(message)
        }
        dbManager.delete(id)
    }

    fun updateContact(contact: InfoPersonal) {
        dbManager.update(contact)
    }

    fun getContactByFullName(fullName: String): InfoPersonal {
        var result = dbManager.getByFullName(fullName)
        if (result == null) {
            val message = _context.getString(R.string.Green_Not_Found)
            throw Exception(message)
        }
        return result
    }
}