package cr.ac.utn.GreenHabits

import Util.util
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnviewchallenges = findViewById<Button>(R.id.btnviewchallenges)
        btnviewchallenges.setOnClickListener(View.OnClickListener { view ->
            val trying = Intent(this, ChallengesActivity::class.java)
            util.openActivity(this,ChallengesActivity::class.java)
        })

        val btnviewstats = findViewById<Button>(R.id.btnviewStats)
        btnviewstats.setOnClickListener(View.OnClickListener { view ->
            val trying = Intent(this, StatsActivity::class.java)
            util.openActivity(this,StatsActivity::class.java)
        })

        val btnviewstart = findViewById<Button>(R.id.btnviewstart)
        btnviewstart.setOnClickListener(View.OnClickListener { view ->
            val trying = Intent(this, MainActivity::class.java)
            util.openActivity(this,MainActivity::class.java)
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_view_challenges ->{
                Util.openActivity(this,ChallengesActivity::class.java)
                return true
            }

            R.id.menu_view_stats ->{
                Util.openActivity(this,StatsActivity::class.java)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }


 */
}