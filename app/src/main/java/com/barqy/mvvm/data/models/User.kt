package com.barqy.mvvm.data.models

import androidx.room.*

@Entity(indices = [Index("username", unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true)
    val userID:Int,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name= "role") val role: String
)