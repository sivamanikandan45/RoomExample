package com.example.roomexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao():UserDAO

    companion object{
        @Volatile
        private var dbInstance:AppDatabase?=null

        fun getDB(context: Context):AppDatabase{
            val temp= dbInstance
            if(temp != null){
                //dbInstance=Room.databaseBuilder(context, UserDB::class.java, "database-name").build()
                return temp
            }
            synchronized(this){
                val newInstance=Room.databaseBuilder(context, AppDatabase::class.java, "user_db").build()
                dbInstance=newInstance
                return newInstance
            }
            //return dbInstance
        }
        //val DB= Room.databaseBuilder(), UserDB::class.java, "database-name").build()
    }
}