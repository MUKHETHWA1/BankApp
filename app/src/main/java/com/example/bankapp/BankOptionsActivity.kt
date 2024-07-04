package com.example.bankapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BankOptionsActivity : AppCompatActivity() {
    lateinit var balance:Button
    lateinit var withdraw:Button
    lateinit var deposit:Button
    lateinit var registeracc:Button
    lateinit var exit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_options)
        balance=findViewById(R.id.btnCheckBalance)
        withdraw=findViewById(R.id.btnWithdraw)
        deposit=findViewById(R.id.btnDeposit)
        registeracc=findViewById(R.id.btnAccRegister)
        exit=findViewById(R.id.btnExit)

        balance.setOnClickListener {
            val balance = Intent(this,CheckBalanceActivity::class.java)
            startActivity(balance)
        }

    }
}