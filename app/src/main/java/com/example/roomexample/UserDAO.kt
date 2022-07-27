package com.example.roomexample

import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    fun addUser(user:User)

    @Query("SELECT * FROM USER")
    fun viewAll():List<User>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}