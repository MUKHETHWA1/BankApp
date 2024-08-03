package com.example.bankapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var signintextview:TextView
    lateinit var signinbutton:Button
    lateinit var usernameedittext:EditText
    lateinit var passwordedittext:EditText

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signintextview=findViewById(R.id.tvSignIn)
        signinbutton=findViewById(R.id.btnRegister)

        usernameedittext = findViewById(R.id.etEmailRegister)
        passwordedittext = findViewById(R.id.etPasswordRegister)

        auth=FirebaseAuth.getInstance()

        signintextview.setOnClickListener {
            val emailR=usernameedittext.text.toString()
            val passR=passwordedittext.text.toString()

            if(emailR.isNotEmpty()&& passR.isNotEmpty()){

                auth.createUserWithEmailAndPassword(emailR,passR).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent= Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()

                    }
                }
            }else{
                Toast.makeText(this,"empty fields not allowed",Toast.LENGTH_SHORT).show()
            }

        }
        signinbutton.setOnClickListener {
            val next = Intent(this,MainActivity::class.java)
            startActivity(next)
        }

    }
}