package com.barqy.mvvm.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.barqy.mvvm.data.models.Task
import com.barqy.mvvm.data.models.User
import com.barqy.mvvm.data.models.crossRef.UserTaskCrossRef

data class UserWithTasks(
    @Embedded val user:User,
    @Relation(
        parentColumn = "userID",
        entityColumn = "taskID",
        associateBy = Junction(UserTaskCrossRef::class)
    )
    val tasks: List<Task>
)