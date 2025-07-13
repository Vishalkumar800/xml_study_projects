package com.rach.xmlstudy3project

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rach.xmlstudy3project.databinding.ActivityMainBinding
import com.rach.xmlstudy3project.studyFragments.StudyFragActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.countdown.setOnClickListener {
            val intent = Intent(this , CountDownTimerActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.setOnClickListener {
            val intent = Intent(this , RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        binding.fragmentStudy.setOnClickListener {
            val intent = Intent(this , StudyFragActivity::class.java)
            startActivity(intent)
        }

    }
    /**
     * TopAppBar
     */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this,"Add Contact Click",Toast.LENGTH_LONG).show()
            R.id.mi_settings -> Toast.makeText(this ,"You Clicked On Favourites",Toast.LENGTH_SHORT).show()
            R.id.mi_Close -> finish()
            R.id.mi_feedback -> Toast.makeText(this,"Your feedback added",Toast.LENGTH_SHORT).show()
            R.id.mi_Favourites ->{
                Toast.makeText(this , "Added To Your Favourites",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

}