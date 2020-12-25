package com.yfl.livedata

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yfl.livedata.tRoom.AppDatabase


/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 15:02
 * @Purpose :
 */
class AppApplication : Application() {
    public lateinit var mAppDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()
        mAppDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "android_room.db"
        )
            .allowMainThreadQueries()
//            .addMigrations(MIGRATION_1_2)
            .build()


    }

    /**
     * 数据库版本 1->2 user表格新增了age列
     */
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE User ADD COLUMN age integer")
        }
    }

}