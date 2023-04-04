package com.app.calculatorbasic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var etNo1: EditText
    private lateinit var etNo2: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNo1 = findViewById(R.id.editNo1)
        etNo2 = findViewById(R.id.editNo2)
        resultText = findViewById(R.id.resultText)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        btnAdd.setOnClickListener {
            performOperation(Addition())
        }

        btnSub.setOnClickListener {
            performOperation(Subtraction())
        }

        btnMul.setOnClickListener {
            performOperation(Multiplication())
        }

        btnDiv.setOnClickListener {
            performOperation(Division())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun performOperation(operation: Operation) {
        val no1 = etNo1.text.toString()
        val no2 = etNo2.text.toString()

        if (no1.isEmpty() || no2.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
        } else {
            try {
                val result = operation.calculate(no1.toBigDecimal(), no2.toBigDecimal())
                resultText.text = result.toString()
                etNo1.setText("")
                etNo2.setText("")
            } catch (e: ArithmeticException) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }

    abstract class Operation {
        abstract fun calculate(no1: BigDecimal, no2: BigDecimal): BigDecimal
    }

    class Addition : Operation() {
        override fun calculate(no1: BigDecimal, no2: BigDecimal): BigDecimal {
            return no1 + no2
        }
    }

    class Subtraction : Operation() {
        override fun calculate(no1: BigDecimal, no2: BigDecimal): BigDecimal {
            return no1 - no2
        }
    }

    class Multiplication : Operation() {
        override fun calculate(no1: BigDecimal, no2: BigDecimal): BigDecimal {
            return no1 * no2
        }
    }

    class Division : Operation() {
        override fun calculate(no1: BigDecimal, no2: BigDecimal): BigDecimal {
            if (no2 == BigDecimal.ZERO) {
                throw ArithmeticException()
            }
            return no1.divide(no2)
        }
    }
}



//package com.app.calculatorbasic
//
//import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity() {
//
//
//    @SuppressLint("CutPasteId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        val etNo1 = findViewById<EditText>(R.id.editNo1)
//        val etNo2 = findViewById<EditText>(R.id.editNo2)
//
//        val btnAdd = findViewById<Button>(R.id.btnAdd)
//        val btnSub = findViewById<Button>(R.id.btnSub)
//        val btnMul = findViewById<Button>(R.id.btnMul)
//        val btnDiv = findViewById<Button>(R.id.btnDiv)
//        var resultText = findViewById<TextView>(R.id.resultText)
//
//
//
//        btnAdd.setOnClickListener {
//            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
//            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
//
//            if (no1.isEmpty() || no2.isEmpty()) {
//                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
//            } else {
//                val sum = no1.toBigInteger() + no1.toBigInteger()
//                resultText.text = sum.toString()
//            }
//        }
//
//        btnSub.setOnClickListener {
//            var no1 = findViewById<EditText>(R.id.editNo1).text.toString()
//            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
//            if (no1.isEmpty() || no2.isEmpty()) {
//                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
//            } else {
//                val sub = no1.toBigInteger() - no2.toBigInteger()
//                resultText.text = sub.toString()
//                etNo1.setText(resultText.text.toString())
//                etNo2.setText("")
//            }
//        }
//
//        btnMul.setOnClickListener {
//            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
//            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
//            if (no1.isEmpty() || no2.isEmpty()) {
//                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
//            } else {
//                val mul = no1.toBigInteger() * no2.toBigInteger()
//                resultText.text = mul.toString()
//            }
//        }
//
//        btnDiv.setOnClickListener {
//            val no1 = findViewById<EditText>(R.id.editNo1).text.toString()
//            val no2 = findViewById<EditText>(R.id.editNo2).text.toString()
//            if (no1.isEmpty() || no2.isEmpty()) {
//                Toast.makeText(this, "Please fill blank fields", Toast.LENGTH_SHORT).show()
//            } else {
//                if (no2.toInt() > 0) {
//                    val div = no1.toBigDecimal() / no2.toBigDecimal()
//                    resultText.text = div.toString()
//                }
//                else{
//                    Toast.makeText(this, "Can not divide the number by 0", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//
//    }
//}
//
