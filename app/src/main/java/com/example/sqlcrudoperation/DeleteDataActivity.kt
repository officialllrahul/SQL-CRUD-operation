package com.example.sqlcrudoperation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DeleteDataActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_data)

        val deleteIdEdit=findViewById<EditText>(R.id.deleteId)
        val deleteDataBtn=findViewById<Button>(R.id.deleteDataBtn)

        deleteDataBtn.setOnClickListener {
            val db = DataBaseHelper(this, null)
            val deleteId=deleteIdEdit.text.toString()
            db.deleteDatabaseData(deleteId)
    
            Toast.makeText(this,  "Data deleted successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,RetriveActivity::class.java))
        }
    }
}