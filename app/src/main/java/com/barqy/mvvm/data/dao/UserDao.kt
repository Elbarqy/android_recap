package com.barqy.mvvm.data.dao

import androidx.room.*
import com.barqy.mvvm.data.models.Task
import com.barqy.mvvm.data.models.User
import com.barqy.mvvm.data.models.crossRef.UserTaskCrossRef
import com.barqy.mvvm.data.models.relations.UserWithTasks

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("Select * FROM user WHERE userID IN (:userIds)")
    fun loadAllById(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, second: String): User

    @Transaction
    @Query("SELECT * FROM user")
    fun getUsersWithTasks(): List<UserWithTasks>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserTaskCrossRef(userTaskCrossRef: UserTaskCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun delete(user: User)
}