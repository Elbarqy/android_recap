package com.barqy.mvvm.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.barqy.mvvm.data.models.Task
import com.barqy.mvvm.data.models.User

data class UserAndTask(
    @Embedded val task: Task,
    @Relation(
        parentColumn = "userID",
        entityColumn = "userID"
    )
    val user: User
)