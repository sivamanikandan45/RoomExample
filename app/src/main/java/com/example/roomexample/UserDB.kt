package com.example.roomexample

import android.app.Activity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDB:RoomDatabase() {
    abstract fun userDao():UserDAO
    val userdao=DB.userDao()


    companion object{
        val DB= Room.databaseBuilder(Activity(), UserDB::class.java, "database-name").build()
    }
}