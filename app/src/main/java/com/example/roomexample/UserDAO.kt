package com.example.roomexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    fun addUser(user:User)

    @Query("SELECT * FROM USER")
    fun viewAll():List<User>
}