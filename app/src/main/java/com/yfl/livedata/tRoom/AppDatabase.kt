package com.yfl.livedata.tRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.tRoom
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 14:59
 * @Purpose :
 */
@Database(entities = [User::class], version = 1)
@TypeConverters(Converters::class)
public abstract class AppDatabase : RoomDatabase() {

    public abstract fun userDao(): UserDao
}