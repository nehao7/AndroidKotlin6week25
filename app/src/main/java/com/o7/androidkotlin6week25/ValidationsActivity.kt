package com.o7.androidkotlin6week25

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7.androidkotlin6week25.databinding.ActivityValidationsBinding

class ValidationsActivity : AppCompatActivity() {
    lateinit var binding:ActivityValidationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityValidationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnValidate.setOnClickListener {
            if (binding.edtName.text.toString().isNullOrEmpty()) {
                binding.edtName.error="Enter correct name"
            }else{
                Toast.makeText(this, binding.edtName.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}