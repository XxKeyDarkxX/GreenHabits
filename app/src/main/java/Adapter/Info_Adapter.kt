package Adapter

import Entities.InfoPersonal
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import cr.ac.utn.GreenHabits.R



class Info_Adapter(private  val context: Context, private val resource: Int, private val  dataSource: List<InfoPersonal>)
    :ArrayAdapter<InfoPersonal>(context,resource,dataSource){
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as  LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = inflater.inflate(R.layout.activity_custom_menu, parent,false)
        var viewid = view.findViewById(R.id.Cen_CustomLID) as TextView
        var viewname = view.findViewById(R.id.Cen_CustomLName) as TextView
        var viewlastname = view.findViewById(R.id.Cen_CustomLILastName) as TextView
        var viewPhone = view.findViewById(R.id.Cen_CustomLIPhone) as TextView
        var viewEmail = view.findViewById(R.id.Cen_CustomLiEmail) as TextView
        var viewimage = view.findViewById(R.id.imageView3) as ImageView



        val Census = dataSource[position] as InfoPersonal
        viewid.text = Census.id
        viewname.text = Census.name
        viewlastname.text = Census.lastName
        viewPhone.text = Census.phone.toString()
        viewEmail.text = Census.email
        return view

    }
}