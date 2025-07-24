package com.o7.androidkotlin6week25

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.o7.androidkotlin6week25.BottomNav.BottomNavActivity
import com.o7.androidkotlin6week25.databinding.ActivityMainBinding
import com.o7.androidkotlin6week25.firbase.FirestoreActivity
import com.o7.androidkotlin6week25.firbase.LoginActivity
import com.o7.androidkotlin6week25.firbase.RegisterActivity
import com.o7.androidkotlin6week25.fragments_nav_controller.NavControllerActivity
import com.o7.androidkotlin6week25.recyclerpackage.RecyclerActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var btn: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn=findViewById(R.id.btnNext)

        Glide.with(this)
            .load("https://thumbs.dreamstime.com/b/beautiful-rain-forest-ang-ka-nature-trail-doi-inthanon-national-park-thailand-36703721.jpg")
            .into(binding.glideImgView);
        btn?.setOnClickListener {
            Toast.makeText(this,"On Click Message displayed",Toast.LENGTH_SHORT).show()
            var intent=Intent(this,LinaerLayoutScreen::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnImplicit).setOnClickListener {
            var value=findViewById<EditText>(R.id.edtData).text.toString()
           var intent=Intent(this, ImplicitIntentActivity::class.java)
               .putExtra("data",value)
           startActivity(intent)
        }
         findViewById<Button>(R.id.btnConstraintScreen).setOnClickListener {
           var intent=Intent(this, ConstraintActivity::class.java)
               .putExtra("data","My data")
           startActivity(intent)
        }
        findViewById<Button>(R.id.btnSpinner).setOnClickListener {
           var intent=Intent(this, SpinnerActivity::class.java)
               .putExtra("data","My data")
           startActivity(intent)
        }
        findViewById<Button>(R.id.btnValidation).setOnClickListener {
           var intent=Intent(this, ValidationsActivity::class.java)
               .putExtra("data","My data")
           startActivity(intent)
        }
     findViewById<Button>(R.id.btnNavController).setOnClickListener {
           var intent=Intent(this, NavControllerActivity::class.java)

         startActivity(intent)
        }

    findViewById<Button>(R.id.btnRegisterScreen).setOnClickListener {
           var intent=Intent(this, RegisterActivity::class.java)

        startActivity(intent)
        }
  findViewById<Button>(R.id.btnLoginScreen).setOnClickListener {
           var intent=Intent(this, LoginActivity::class.java)

        startActivity(intent)
        }

        findViewById<Button>(R.id.btnRecyclerActivity).setOnClickListener {
           var intent=Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnFirestoreActivity).setOnClickListener {
           var intent=Intent(this, FirestoreActivity::class.java)
            startActivity(intent)
        }
 findViewById<Button>(R.id.btnBottomNav).setOnClickListener {
           var intent=Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
        }



    }
}