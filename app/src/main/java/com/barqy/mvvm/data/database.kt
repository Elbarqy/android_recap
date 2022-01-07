package com.barqy.mvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.barqy.mvvm.data.dao.UserDao
import com.barqy.mvvm.data.models.Task
import com.barqy.mvvm.data.models.User
import com.barqy.mvvm.data.models.crossRef.UserTaskCrossRef

@Database(entities = [User::class, Task::class, UserTaskCrossRef::class], version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null
        fun getInstance(context: Context): UserDataBase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "user_db",
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}