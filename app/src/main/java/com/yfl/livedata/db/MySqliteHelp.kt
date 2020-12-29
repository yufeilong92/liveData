package com.yfl.livedata.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.db
 * @Email : yufeilong92@163.com
 * @Time :2020/12/29 13:33
 * @Purpose :
 */
class MySqliteHelp(val mContext: Context, var sqlName: String, var sqlVersion: Int) :
    SQLiteOpenHelper(mContext, sqlName, null, sqlVersion) {
    companion object {//被companion object包裹的语句都是private的

        private var singletonInstance: MySqliteHelp? = null

        @Synchronized
        fun getInstance(mContext: Context, sqlName: String, sqlVersion: Int): MySqliteHelp? {
            if (singletonInstance == null) {
                singletonInstance = MySqliteHelp(mContext, sqlName, sqlVersion)
            }
            return singletonInstance
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val userSql="create table user(id varchar AUTO_INCREMENT," +
                "name text," +
                "age Integer," +
                "class text)"
        db?.execSQL(userSql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}