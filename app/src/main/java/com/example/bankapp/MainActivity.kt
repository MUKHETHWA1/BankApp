package com.example.bankapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var signuptextview:TextView
    lateinit var signinbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signuptextview=findViewById(R.id.tvSignUp)
        signinbutton=findViewById(R.id.btnLoginA)

        signuptextview.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        signinbutton.setOnClickListener {
            val nextoption=Intent(this,BankOptionsActivity::class.java)
            startActivity(nextoption)
        }

    }
}