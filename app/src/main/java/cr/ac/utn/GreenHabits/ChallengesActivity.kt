package cr.ac.utn.GreenHabits

import Adapter.Info_Adapter
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import Entities.InfoPersonal
import Model.InfoModel
import Util.EXTRA_MESSAGE_ID
import Util.util



class ChallengesActivity : AppCompatActivity() {

    lateinit var model: InfoModel
    lateinit var contact : List<InfoPersonal>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_challenges)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val info_model = InfoModel(this)
        val Contactlistview =  findViewById<ListView>(R.id.Contactlistwiew)
        contact = info_model.getContacts()


        val adapter = Info_Adapter(this, R.layout.activity_challenges,contact)
        Contactlistview.adapter = adapter
        Contactlistview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> val Cname = contact[position].fullName
            util.openActivity(this, StatsActivity::class.java, EXTRA_MESSAGE_ID,Cname)

        }
    }
}

