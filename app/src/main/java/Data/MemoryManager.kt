package Data

import Entities.InfoPersonal
import Interface.IDBmanager

object MemoryManager:IDBmanager {

    private var ContactList = mutableListOf<InfoPersonal>()
    override fun add(infopersonal: InfoPersonal) {
        TODO("Not yet implemented")
    }

    override fun update(infopersonal: InfoPersonal) {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): InfoPersonal? {
        TODO("Not yet implemented")
    }

    override fun getByFullName(fullName: String): InfoPersonal? {
        TODO("Not yet implemented")
    }

}