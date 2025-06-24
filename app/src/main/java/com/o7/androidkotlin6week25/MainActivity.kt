package com.o7.androidkotlin6week25

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var btn: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn=findViewById(R.id.btnNext)

        btn?.setOnClickListener {
            Toast.makeText(this,"On Click Message displayed",Toast.LENGTH_SHORT).show()
            var intent=Intent(this,LinaerLayoutScreen::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnImplicit).setOnClickListener {
           var intent=Intent(this, ImplicitIntentActivity::class.java)
               .putExtra("data","My data")
           startActivity(intent)
        }
         findViewById<Button>(R.id.btnImplicit).setOnClickListener {
           var intent=Intent(this, ConstraintActivity::class.java)
               .putExtra("data","My data")
           startActivity(intent)
        }



    }
}