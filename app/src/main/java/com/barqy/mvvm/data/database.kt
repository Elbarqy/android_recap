package com.barqy.mvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.barqy.mvvm.data.dao.UserDao
import com.barqy.mvvm.data.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}