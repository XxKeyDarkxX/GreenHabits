package Interface

import Entities.InfoPersonal

interface IDBmanager {

    fun add (infopersonal: InfoPersonal)
    fun update(infopersonal: InfoPersonal)
    fun delete(id: String)
    fun getAll (): List<InfoPersonal>
    fun getById(id: String): InfoPersonal?
    fun getByFullName(fullName: String): InfoPersonal?

}