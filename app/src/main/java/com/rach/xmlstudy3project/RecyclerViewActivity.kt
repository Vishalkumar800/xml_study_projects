package com.rach.xmlstudy3project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rach.xmlstudy3project.adapter.MainAdapter
import com.rach.xmlstudy3project.databinding.ActivityRecyclerViewBinding
import com.rach.xmlstudy3project.utils.TaskList

class RecyclerViewActivity : AppCompatActivity() {
    private var binding : ActivityRecyclerViewBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = MainAdapter(TaskList.taskList())
        binding?.recyclerView1?.adapter =  adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}