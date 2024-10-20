package Util

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class Util {

    companion object{
        fun openActivity(context: Context, objClass:Class<*>){
            val inten = Intent(context, objClass)
            startActivity(context,inten,null)
        }
    }

}