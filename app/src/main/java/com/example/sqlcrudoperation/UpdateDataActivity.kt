package com.example.sqlcrudoperation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        val id=findViewById<EditText>(R.id.UpdateId)
        val upDateName=findViewById<EditText>(R.id.UpdateName)
        val upDateEmail=findViewById<EditText>(R.id.UpdateEmail)
        val upDateUserId=findViewById<EditText>(R.id.UpdateUsername)
        val upDatePassword=findViewById<EditText>(R.id.UpdatePassword)
        val upDateContact=findViewById<EditText>(R.id.UpdateContact)
        val upDateBtn=findViewById<Button>(R.id.UpdateOldData)

        upDateBtn.setOnClickListener {
            val db = DataBaseHelper(this, null)
            val id=id.text.toString()
            val upDateNameData = upDateName.text.toString()
            val upDateEmailData = upDateEmail.text.toString()
            val upDateUserData = upDateUserId.text.toString()
            val upDatePasswordData = upDatePassword.text.toString()
            val upDateContactData = upDateContact.text.toString()
            db.updateDatabaseData(id,upDateNameData, upDateEmailData, upDateUserData, upDatePasswordData, upDateContactData)

            Toast.makeText(this,"Data updated successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,RetriveActivity::class.java))
        }

    }
}