package com.rach.xmlstudy3project.studyFragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rach.xmlstudy3project.R
import com.rach.xmlstudy3project.databinding.ActivityStudyFragBinding

class StudyFragActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudyFragBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStudyFragBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout_study, firstFragment)
            commit()
        }

        binding.fragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout_study, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.fragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout_study, secondFragment)
                commit()
            }
        }

    }
}