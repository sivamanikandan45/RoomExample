package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserListActivity : AppCompatActivity() {
    private lateinit var db:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        db= AppDatabase.getDB(this)
        viewData()
    }

    private fun viewData() {
        GlobalScope.launch(Dispatchers.IO) {
            val list=db.userDao().viewAll()
            var string=""
            for(i in list.indices){
                string+=list[i].id.toString()+"\t\t\t"+list[i].uname+"\t\t\t"+list[i].password+"\n"
            }
            val textView=findViewById<TextView>(R.id.result_label)
            textView.text=string
        }
    }
}