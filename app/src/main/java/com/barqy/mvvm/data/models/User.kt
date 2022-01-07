package com.barqy.mvvm.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val userID:Int,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name= "second_name") val secondName: String
)