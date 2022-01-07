package com.barqy.mvvm.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.barqy.mvvm.data.models.UserLogs

@Dao
interface getUsersWith {
    @Transaction
    @Query("SELECT * FROM user")
    fun getUsersWithTasks():List<UserLogs>;
}