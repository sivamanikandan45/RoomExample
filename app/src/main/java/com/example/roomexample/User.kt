package com.example.roomexample

import androidx.room.Entity

@Entity(tableName = "user")
data class User(val uname:String,val password:String)