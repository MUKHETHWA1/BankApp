package com.example.bankapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    lateinit var signintextview:TextView
    lateinit var signinbutton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signintextview=findViewById(R.id.tvSignIn)
        signinbutton=findViewById(R.id.btnRegister)

        signintextview.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        signinbutton.setOnClickListener {
            val next = Intent(this,MainActivity::class.java)
            startActivity(next)
        }

    }
}