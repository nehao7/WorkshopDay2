package com.o7services.workshopday2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var btnLifecycle:Button?=null
    var btnCal:Button?=null
    var edtContact:EditText?=null
    var btnCall:Button?=null
    var btnView:Button?=null
    var btnmail:Button?=null
    var btnSms:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLifecycle=findViewById(R.id.btnLifecycle)
        btnCal=findViewById(R.id.btnCalculator)
        edtContact=findViewById(R.id.edtContact)
        btnCall=findViewById(R.id.btnCall)
        btnView=findViewById(R.id.btnViewSite)
        btnmail=findViewById(R.id.btnEmail)
        btnSms=findViewById(R.id.btnSms)

        btnLifecycle?.setOnClickListener {
            var intent=Intent(this,ActivityLifecycle::class.java)
            startActivity(intent)
        }
        btnCal?.setOnClickListener {
            var intent=Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }

        btnView?.setOnClickListener {
            var intent = Intent()
            intent.setAction( Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com/"))
            startActivity(intent)
        }

        btnCall?.setOnClickListener {
            if (edtContact?.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Enter the number first", Toast.LENGTH_SHORT).show()
            }else{
            try{
                var intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:${edtContact?.text.toString()}"))
                startActivity(intent)
            }catch(exception : Exception){
                Toast.makeText(this, "Cannot call  on this  number", Toast.LENGTH_SHORT).show()
            }
            }
        }
        btnSms?.setOnClickListener {
            val intent= Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("sms:${edtContact?.text.toString()}"))
            intent.putExtra("sms_body", "Hello! This is a test SMS message.")
            startActivity(intent)
        }
        btnmail?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("o7services046@gmail.com"))
            intent.putExtra("subject","My Mail")
            intent.putExtra("body","Greetings to all🎉🎉🎉🎉")
            startActivity(intent)
        }
    }
}