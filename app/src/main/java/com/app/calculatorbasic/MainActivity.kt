package com.app.calculatorbasic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        var resultText = findViewById<TextView>(R.id.resultText)


        btnAdd.setOnClickListener {
            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
            if(no1.isEmpty() || no2.isEmpty()){
                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val sum = no1.toInt() + no2.toInt()
                resultText.text = sum.toString()
            }
        }

        btnSub.setOnClickListener {
            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
            if(no1.isEmpty() || no2.isEmpty()){
                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val sub = no1.toInt() - no2.toInt()
                resultText.text = sub.toString()
            }
        }

        btnMul.setOnClickListener {
            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
            if(no1.isEmpty() || no2.isEmpty()){
                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val mul = no1.toInt() * no2.toInt()
                resultText.text = mul.toString()
            }
        }

        btnDiv.setOnClickListener {
            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
            if(no1.isEmpty() || no2.isEmpty()){
                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val div = no1.toFloat() / no2.toFloat()
                resultText.text = div.toString()
            }
        }

    }
}

