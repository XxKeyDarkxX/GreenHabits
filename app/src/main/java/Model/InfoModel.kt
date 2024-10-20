package Model

import Data.MemoryManager
import Entities.InfoPersonal
import Interface.IDBmanager
import android.content.Context
import cr.ac.utn.GreenHabits.R

class InfoModel{
        private var dbManager: IDBmanager= MemoryManager
        private lateinit var _context: Context

         constructor(context: Context){
             _context= context}
}