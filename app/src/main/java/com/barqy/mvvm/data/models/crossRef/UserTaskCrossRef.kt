package com.barqy.mvvm.data.models.crossRef

import androidx.room.Entity
import java.sql.Date

@Entity(primaryKeys = ["userID", "taskID"])
data class UserTaskCrossRef(
    val userID: Int,
    val taskID: Int,
    val note:String,
)