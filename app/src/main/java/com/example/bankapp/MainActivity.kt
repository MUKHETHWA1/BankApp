package com.example.bankapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var signuptextview:TextView
    lateinit var signinbutton:Button
    lateinit var emaillogin:EditText
    lateinit var passlogin:EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signuptextview=findViewById(R.id.tvSignUp)
        signinbutton=findViewById(R.id.btnLoginA)

        emaillogin = findViewById(R.id.etEmailLogin)
        passlogin = findViewById(R.id.etPasswordLogin)
        //firebase
        auth=FirebaseAuth.getInstance()

        signuptextview.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        signinbutton.setOnClickListener {
            val email=emaillogin.text.toString()
            val pass=passlogin.text.toString()
            if(email.isNotEmpty()&& pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if(it.isSuccessful){
                        val nextoption=Intent(this,BankOptionsActivity::class.java)
                        startActivity(nextoption)
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }

            }else {
                Toast.makeText(this, "empty fields not allowed", Toast.LENGTH_SHORT).show()
            }

        }

    }
}