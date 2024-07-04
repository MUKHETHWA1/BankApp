package com.example.bankapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WithdrawActivity : AppCompatActivity() {
    lateinit var back: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_withdraw)
        back=findViewById(R.id.btnBackWithdraw)

        back.setOnClickListener {
            val back = Intent(this,BankOptionsActivity::class.java)
            startActivity(back)
        }

    }
}