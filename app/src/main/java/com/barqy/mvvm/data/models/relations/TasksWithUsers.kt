package com.barqy.mvvm.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.barqy.mvvm.data.models.Task
import com.barqy.mvvm.data.models.User
import com.barqy.mvvm.data.models.crossRef.UserTaskCrossRef

data class TasksWithUsers(
    @Embedded val task: Task,
    @Relation(
        parentColumn = "taskID",
        entityColumn = "userID",
        associateBy = Junction(UserTaskCrossRef::class)
    )
    val users: List<User>
)