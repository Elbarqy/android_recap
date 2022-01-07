package com.barqy.mvvm.data.models

import androidx.room.*
import java.sql.Date
@Entity(primaryKeys = [])
data class Logs(
    val userID:Int,
    val taskID:Int
)