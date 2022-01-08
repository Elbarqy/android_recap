package com.barqy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.barqy.mvvm.data.UserDataBase
import com.barqy.mvvm.data.models.Task
import com.barqy.mvvm.data.models.User
import com.barqy.mvvm.data.models.crossRef.UserTaskCrossRef
import com.barqy.mvvm.data.models.relations.UserWithTasks
import kotlinx.coroutines.launch
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userDao = UserDataBase.getInstance(this).userDao()
//
        val users = listOf<User>(
            User(0, "consumer_1", "ADMIN"),
            User(0, "consumer_2", "Guest")
        )
        val tasks = listOf<Task>(
            Task(0, "Do that", 0, users[0].userID),
            Task(0, "Do this", 2, users[0].userID),
        )
        val userTasksDone = listOf<UserTaskCrossRef>(
            UserTaskCrossRef(
                6,
                0,
                "I did it myself you bastards"
            ),
            UserTaskCrossRef(
                5,
                1,
                "I have it all under control boss!"
            )
        );
        Thread{
            userDao.removeAllTasks()
            userDao.removeAllUsers()
            users.forEach{
                userDao.insertUser(it)
            }
            tasks.forEach{
                userDao.insertTask(it)
            }
            userTasksDone.forEach {
                userDao.insertUserTaskCrossRef(it)
            }
            val x: List<UserWithTasks> = userDao.getUsersWithTasks()
            if(x.size > 0){
                Log.i("userData" , x.toString())
            }
            Log.w("DataBase Activity", toString())
        }.start()
    }
}