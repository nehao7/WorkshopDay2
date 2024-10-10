package com.o7services.workshopday2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    var edt1: EditText? = null
    var edt2: EditText? = null
    var result: TextView? = null
    var btnAdd: Button? = null
    var btnSub: Button? = null
    var btnMul: Button? = null
    var btnDiv: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        result = findViewById(R.id.tvResult)
        btnAdd?.setOnClickListener {
            if (edt1?.text.toString().isNullOrEmpty()&&edt2?.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "enter the values first", Toast.LENGTH_SHORT).show()
            }else{
            result?.setText(
                edt1?.text.toString().toDouble().plus(edt2?.text.toString().toDouble()).toString()
            )
            }
        }
        btnSub?.setOnClickListener {
            if (edt1?.text.toString().isNullOrEmpty()&&edt2?.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "enter the values first", Toast.LENGTH_SHORT).show()
            }else{
            result?.setText(
                edt1?.text.toString().toDouble().minus(edt2?.text.toString().toDouble()).toString()
            )
            }
        }
        btnMul?.setOnClickListener {
            if (edt1?.text.toString().isNullOrEmpty()&&edt2?.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "enter the values first", Toast.LENGTH_SHORT).show()
            }else{
            result?.setText(
                edt1?.text.toString().toDouble().times(edt2?.text.toString().toDouble()).toString()
            )
            }
        }
        btnDiv?.setOnClickListener {
            if (edt1?.text.toString().isNullOrEmpty()&&edt2?.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "enter the values first", Toast.LENGTH_SHORT).show()
            }else{
            result?.setText(
                edt1?.text.toString().toDouble().div(edt2?.text.toString().toDouble()).toString()
            )
            }
        }

    }
}