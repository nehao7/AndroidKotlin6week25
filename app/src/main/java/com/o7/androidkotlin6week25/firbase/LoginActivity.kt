package com.o7.androidkotlin6week25.firbase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.o7.androidkotlin6week25.R
import com.o7.androidkotlin6week25.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    var db=Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            btnsave.setOnClickListener {
                if (edtemail.text.toString().isNullOrEmpty().not()){
                val docRef = db.collection("user")
//                    .whereEqualTo("email", binding.edtemail.text.toString())
//                    .limit(1)
                    .get()
                    .addOnSuccessListener {


                        val matchedDoc = it.documents.find {
                            it.getString("email")?.equals(edtemail.text.toString().trim(), ignoreCase = true) == true
                        }
                        if (matchedDoc!=null){
                        var user = matchedDoc.toObject(RegisterModel::class.java)}
                        else{
                            Toast.makeText(this@LoginActivity, "Docs not found", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener {e->
                        Toast.makeText(this@LoginActivity,e.message.toString(), Toast.LENGTH_SHORT).show()

                    }
//                        if (!it.isEmpty){
//                        var doc = it.documents[0]
//
//                        if (user?.type == 0) {
//                            Toast.makeText(this@LoginActivity, "User Type = ${user.type}", Toast.LENGTH_SHORT)
//                                .show()
//                        } else {
//                            Toast.makeText(this@LoginActivity, "User Type = ${user?.type}", Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                        }
//                    }
//                }else{
//                    Toast.makeText(this@LoginActivity, "Enter Email", Toast.LENGTH_SHORT)
//                        .show()
                }

            }
        }

    }

}