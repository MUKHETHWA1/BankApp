package com.example.bankapp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.Statement

class CheckBalanceActivity : AppCompatActivity() {
    lateinit var backbutton:Button
    lateinit var checkbutton:Button
    lateinit var displaytext:TextView
    lateinit var searchbalance:EditText

     //Connection To the sql server
    private val connectionUrl = "jdbc:sqlserver://labG9AEB3\\SQLEXPRESS:1433;databaseName=Bank;integratedSecurity=true;"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_check_balance)
        backbutton=findViewById(R.id.btnBackCheckBalance)
        displaytext=findViewById(R.id.tvDisplayBalance)
        searchbalance=findViewById(R.id.edAccIdBalance)
        checkbutton=findViewById(R.id.btnCheck)

        backbutton.setOnClickListener {
            val back=Intent(this,BankOptionsActivity::class.java)
            startActivity(back)
        }
        checkbutton.setOnClickListener {
            val queryValue = searchbalance.text.toString()
            RetrieveDataTask().execute(queryValue)
        }

    }
    /*private inner class StoreDataTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String): String {
            val data1 = params[0]
            val data2 = params[1]
            var connection: Connection? = null
            var statement: Statement? = null

            return try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                connection = DriverManager.getConnection(connectionUrl)
                statement = connection.createStatement()
                val sql = "INSERT INTO YourTable (Column1, Column2) VALUES ('$data1', '$data2')"
                statement.executeUpdate(sql)
                "Data stored successfully"
            } catch (e: Exception) {
                e.message ?: "Error"
            } finally {
                statement?.close()
                connection?.close()
            }
        }

        override fun onPostExecute(result: String) {
            displaytext.text = result
        }
    }*/

    private inner class RetrieveDataTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String): String {
            val queryValue = params[0]
            var connection: Connection? = null
            var statement: Statement? = null
            var result: StringBuilder = StringBuilder()

            return try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                connection = DriverManager.getConnection(connectionUrl)
                statement = connection.createStatement()
                val sql = "SELECT * FROM ACCOUNT WHERE AccountID ='$searchbalance'"
                val resultSet: ResultSet = statement.executeQuery(sql)
                val metaData: ResultSetMetaData = resultSet.metaData
                val columnCount: Int = metaData.columnCount

                while (resultSet.next()) {
                    for (i in 1..columnCount) {
                        val columnName = metaData.getColumnName(i)
                        val columnValue = resultSet.getString(i)
                        result.append("$columnName: $columnValue\n")
                    }
                    result.append("\n")
                }
                result.toString()
            } catch (e: Exception) {
                e.message ?: "Error"
            } finally {
                statement?.close()
                connection?.close()
            }
        }

        override fun onPostExecute(result: String) {
            displaytext.text = result
        }
    }
}