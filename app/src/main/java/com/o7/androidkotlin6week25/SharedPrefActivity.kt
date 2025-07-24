package com.o7.androidkotlin6week25

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7.androidkotlin6week25.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPrefBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPreferences=getSharedPreferences("Details", MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        loadData()

        binding.btnSave.setOnClickListener {
            if (binding.edtName.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
            }else{
                editor.putString("name", binding.edtName.text.toString())
                editor.apply()
                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()

            }
        }

        binding.btnDelete.setOnClickListener{
            editor.remove("name")
            editor.apply()
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
            loadData()
        }
        binding.btnChangeMode.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("App Mode Change")
                setPositiveButton("Dark Mode"){_,_->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("dark", true)
                    editor.commit()
                    editor.apply()
                }
                setNegativeButton("Light Mode"){_,_->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor.putBoolean("dark", false)
                    editor.commit()
                    editor.apply()
                }
                show()
            }
        }
    }
    fun loadData(){
        var name=sharedPreferences.getString("name","")
        binding.edtName.setText(name)

        if (sharedPreferences.getBoolean("dark",false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}