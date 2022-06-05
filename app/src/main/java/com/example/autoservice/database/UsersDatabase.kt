package com.example.autoservice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        private var INSTANCE: UsersDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UsersDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, UsersDatabase::class.java, "users_database")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE!!
        }
    }
}