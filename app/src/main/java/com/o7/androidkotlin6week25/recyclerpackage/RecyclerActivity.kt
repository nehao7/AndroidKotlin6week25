package com.o7.androidkotlin6week25.recyclerpackage

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.o7.androidkotlin6week25.R
import com.o7.androidkotlin6week25.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), RecyclerAdapter.OnClickInterface {
    lateinit var binding:ActivityRecyclerBinding
    lateinit var recyclerAdapter: RecyclerAdapter
    var Noteslist= arrayListOf<NotesEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRecyclerBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Noteslist.add(NotesEntity(title = "My title", description = "My description"))
        Noteslist.add(NotesEntity(title = " title 2", description = "My description"))
        Noteslist.add(NotesEntity(title = "My title extra", description = "My description"))
        recyclerAdapter=RecyclerAdapter(Noteslist,this)
        binding.recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter=recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()

        binding.fabBtn.setOnClickListener {
            var dialog = Dialog(this)


            dialog.setContentView(R.layout.custom_layout)

            var mytext = dialog.findViewById<EditText>(R.id.etmyText)

            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            dialog.show()
            var btnCancel = dialog.findViewById<Button>(R.id.btnCancel)

            btnCancel.setOnClickListener{
                
                Noteslist.add(NotesEntity(title = mytext.text.toString()))
                Toast.makeText(this@RecyclerActivity, "${mytext.text}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
    }

    override fun update(position: Int) {
        Toast.makeText(this, "Update Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun delete(position: Int) {
        Noteslist.removeAt(position)
        Toast.makeText(this, "Update Clicked", Toast.LENGTH_SHORT).show()

    }

    override fun onItemClick(position: Int) {

        var intent = Intent(this,NavigateActivity::class.java).apply {
            putExtra("key",Noteslist[position].title.toString())
        }
        startActivity(intent)


    }
}