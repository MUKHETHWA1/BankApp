package com.example.bankapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CheckBalanceActivity : AppCompatActivity() {
    lateinit var backbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_check_balance)
        backbutton=findViewById(R.id.btnBackCheckBalance)

        backbutton.setOnClickListener {
            val back=Intent(this,BankOptionsActivity::class.java)
            startActivity(back)
        }

    }
}