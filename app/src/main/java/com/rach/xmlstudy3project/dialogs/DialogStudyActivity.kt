package com.rach.xmlstudy3project.dialogs

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rach.xmlstudy3project.R
import com.rach.xmlstudy3project.databinding.ActivityDialogStudyBinding

class DialogStudyActivity : AppCompatActivity() {
    private var binding: ActivityDialogStudyBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDialogStudyBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding!!.addContactDailog.setOnClickListener {
            openAddContactDialog(this).show()
        }
        val options = arrayOf("First Item" , "Second Item" , "Third Item")
        binding!!.selectSingleDialog.setOnClickListener {
            singleChoiceDialog(this , options ).show()
        }

        val multipleChoiceDialog = AlertDialog.Builder(this).setTitle("Choose Items")
            .setMultiChoiceItems(options , booleanArrayOf(false,false,false)){ _, i, isChecked ->
                if (isChecked){
                    Toast.makeText(this, "You select ${options[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "You unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }
            }.setPositiveButton("Confirm") { _ , _ ->
                Toast.makeText(this,"You added Mr. Rai to Your Contact List",Toast.LENGTH_SHORT).show()
            }.setNegativeButton("Decline"){ _ , _ ->
                Toast.makeText(this,"You didn't add Mr. Rai to Your Contact List",Toast.LENGTH_SHORT).show()
            }.create()

        binding!!.multipleChoiceDialog.setOnClickListener {
            multipleChoiceDialog.show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding =  null
    }
}

private fun openAddContactDialog(context: Context): AlertDialog {
   val alertDialog =  AlertDialog.Builder(context).setTitle("Add Contact")
        .setIcon(R.drawable.baseline_person_add_24)
        .setMessage("Do you want to add Mr. Rai in Your Contact List")
        .setPositiveButton("Yes"){ _, _ ->
            Toast.makeText(context,"You added Mr. Rai to Your Contact List",Toast.LENGTH_SHORT).show()
        }
        .setNegativeButton("No"){ _ , _ ->
            Toast.makeText(context,"You didn't add Mr. Rai to Your Contact List",Toast.LENGTH_SHORT).show()
        }.create()

    return alertDialog
}

private fun singleChoiceDialog(context: Context,options:Array<String>):AlertDialog{
    val alertDialog = AlertDialog.Builder(context).setTitle("Choose one of these options")
        .setSingleChoiceItems(options,0){ _, i ->
            Toast.makeText(context, "You select ${options[i]}",Toast.LENGTH_SHORT).show()
        }
        .setPositiveButton("Confirm") { _ , _ ->
            Toast.makeText(context,"You added Mr. Rai to Your Contact List",Toast.LENGTH_SHORT).show()
        }.setNegativeButton("Decline"){ _ , _ ->
            Toast.makeText(context,"You didn't add Mr. Rai to Your Contact List",Toast.LENGTH_SHORT).show()
        }.create()

    return alertDialog

}