package com.example.roomexample

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDAO {
    @Insert
    fun addUser(user:User)
}