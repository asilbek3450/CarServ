package com.example.autoservice.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val phoneNumber:String,
    val language: Int
    // 0 -> uzbek
    // 1 -> english
    // 2 -> russian
)