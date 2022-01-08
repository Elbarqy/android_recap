package com.barqy.mvvm.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val taskID: Int,
    @ColumnInfo(name = "task") val taskName: String,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name= "userID")val userID: Int
)