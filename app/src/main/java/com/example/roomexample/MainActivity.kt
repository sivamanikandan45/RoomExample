package com.example.roomexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         db= AppDatabase.getDB(this)
        //db= AppDatabase.getDB(this)

        val btn=findViewById<Button>(R.id.save_btn)
        btn.setOnClickListener {
            saveData()
        }

        val viewBtn=findViewById<Button>(R.id.view_btn)
        viewBtn.setOnClickListener {
            intent= Intent(this,UserListActivity::class.java)
            startActivity(intent)
        }

    }

    private fun saveData() {
        val userTextView=findViewById<EditText>(R.id.username_input)
        val passwordTextView=findViewById<EditText>(R.id.pwd_input)

        val userName:String=userTextView.text.toString()
        val password=passwordTextView.text.toString()
        GlobalScope.launch(Dispatchers.IO) {
            val user=User(0,userName,password)
            db.userDao().addUser(user)
        }

        userTextView.text.clear()
        passwordTextView.text.clear()
    }
}