package com.example.sqlcrudoperation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<EditText>(R.id.enterName)
        val email=findViewById<EditText>(R.id.enterEmail)
        val username=findViewById<EditText>(R.id.enterUsername)
        val password=findViewById<EditText>(R.id.enterPassword)
        val contactTxt=findViewById<EditText>(R.id.enterContact)
        val save=findViewById<Button>(R.id.saveData)
        val resetBtn=findViewById<Button>(R.id.resetData)
        resetBtn.setOnClickListener {
            name.text.clear()
            email.text.clear()
            username.text.clear()
            password.text.clear()
            contactTxt.text.clear()
        }
        save.setOnClickListener {
            val db = DataBaseHelper(this, null)
            val nameData = name.text.toString()
            val emailData = email.text.toString()
            val userData = username.text.toString()
            val passwordData = password.text.toString()
            val contactData = contactTxt.text.toString()
            db.insertData (nameData,emailData, userData, passwordData, contactData)
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()

            name.text.clear()
            email.text.clear()
            username.text.clear()
            password.text.clear()
            contactTxt.text.clear()
            startActivity(Intent(this,RetriveActivity::class.java))
        }


    }
}