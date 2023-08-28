package com.example.sqlcrudoperation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RetriveActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrive)

        val idView=findViewById<TextView>(R.id.retrieveId)
        val nameView=findViewById<TextView>(R.id.retrieveName)
        val emailView=findViewById<TextView>(R.id.retrieveEmail)
        val userNameView=findViewById<TextView>(R.id.retrieveUsername)
        val passwordView=findViewById<TextView>(R.id.retrievePassword)
        val contactView=findViewById<TextView>(R.id.retrieveContact)
        val viewDataBtn=findViewById<Button>(R.id.viewData)
        val updateDataBtn=findViewById<Button>(R.id.updateData)
        val deleteData=findViewById<Button>(R.id.deleteData)
        val insertNewData=findViewById<Button>(R.id.insertData)

        //Retrieve Data on RetrieveActivity
        viewDataBtn.setOnClickListener{
            val db = DataBaseHelper(this, null)
            val cursor = db.viewData()
            cursor!!.moveToFirst()
            idView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.ID_COL))+"\n")
            nameView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME_COl)) + "\n")
            emailView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMAIL_COL)) + "\n")
            userNameView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.USER_COL)) + "\n")
            passwordView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.PASS_COL)) + "\n")
            contactView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.CONTACT_COL)) + "\n")

            while(cursor.moveToNext()){
                idView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.ID_COL))+"\n")
                nameView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME_COl)) + "\n")
                emailView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMAIL_COL)) + "\n")
                userNameView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.USER_COL)) + "\n")
                passwordView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.PASS_COL)) + "\n")
                contactView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.CONTACT_COL)) + "\n")
            }
            cursor.close()
        }

        //Insert New Data in MainActivity
        insertNewData.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        //Delete Inserted Data with id in Delete Activity
        deleteData.setOnClickListener {
            startActivity(Intent(this,DeleteDataActivity::class.java))
        }

        //Update the inserted Data in UpdateDataActivity
        updateDataBtn.setOnClickListener {
            startActivity(Intent(this,UpdateDataActivity::class.java))
        }



    }
}