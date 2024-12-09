package Data

import Interface.IDBmanager
import Entities.InfoPersonal
import android.system.Os.remove


object MemoryManager: IDBmanager {
    private var Info_objectList = mutableListOf<InfoPersonal>()
    override fun add(infopersonal: InfoPersonal) {
        Info_objectList.add(infopersonal)
    }

    override fun update(infopersonal: InfoPersonal) {
        remove(infopersonal.id)
        Info_objectList.add(infopersonal)
    }

    override fun delete(id: String) {
        Info_objectList.removeIf{it.id.trim() == id.trim()}
    }
    fun delete (cen_obje: InfoPersonal){
        Info_objectList.remove(cen_obje)
    }


    override fun getAll(): List<InfoPersonal> = Info_objectList.toList()


    override fun getById(id: String): InfoPersonal? {
        try {
            var result = MemoryManager.Info_objectList.filter { (it.id) == id }
            return if(!result.any()) null else result[0]
        }catch (e: Exception){
            throw e
        }
    }

    override fun getByFullName(fullName: String): InfoPersonal? {
        try {
            var result = Info_objectList.filter { (it.fullName) == fullName }
            return if(!result.any()) null else result[0]
        }catch (e: Exception){
            throw e
        }
    }
}






