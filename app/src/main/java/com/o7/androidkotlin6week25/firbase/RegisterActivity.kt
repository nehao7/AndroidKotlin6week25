package com.o7.androidkotlin6week25.firbase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.o7.androidkotlin6week25.R
import com.o7.androidkotlin6week25.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val TAG = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnsave.setOnClickListener {
            if (binding.edtemail.text.toString().isNullOrEmpty()) {
                binding.tilemail.isErrorEnabled = true
                binding.tilemail.error = "Enter Email"
            } else if (binding.edtPassword.text.toString().isNullOrEmpty()) {
                binding.tilPassword.isErrorEnabled = true
                binding.tilPassword.error = "Enter Password"
            } else {

                auth.createUserWithEmailAndPassword(
                    binding.edtemail.text.toString(),
                    binding.edtPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        val user = auth.currentUser

                        if (task.isSuccessful) {
                            // Registration successful

//                            startActivity(Intent(this, MainActivity::class.java))
                            Toast.makeText(this, "Completed Successful${user?.email}", Toast.LENGTH_SHORT)
                                .show()
//                            finish()
                            // Save user details to Firestore database

                        } else {
                            // Registration failed

                        }
                    }
                    .addOnSuccessListener {
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT)

                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Register", Toast.LENGTH_SHORT)

                    }
            }
        }
    }
}