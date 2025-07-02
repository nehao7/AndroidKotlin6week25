package com.o7.androidkotlin6week25.recyclerpackage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.o7.androidkotlin6week25.R
import com.o7.androidkotlin6week25.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
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
        Noteslist.add(NotesEntity(title = "My title", description = "My description"))
        Noteslist.add(NotesEntity(title = "My title", description = "My description"))
        recyclerAdapter=RecyclerAdapter(Noteslist)
        binding.recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter=recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()
    }
}