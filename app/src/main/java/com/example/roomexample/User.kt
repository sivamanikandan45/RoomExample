package com.example.roomexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(@PrimaryKey(autoGenerate = true)
                val id:Int,
                val uname:String,
                val password:String)