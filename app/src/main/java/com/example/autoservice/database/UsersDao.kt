package com.example.autoservice.database

import androidx.room.*

@Dao
interface UsersDao {

    @Insert
    fun addUser(user: Users)

    @Update
    fun editUser(user: Users)

    @Query("SELECT * FROM users")
    fun listUsers(): List<Users>

    @Delete
    fun deleteUser(user: Users)

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUserById(id: Int): Users
}