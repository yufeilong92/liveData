package com.yfl.livedata

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yfl.livedata.tRoom.AppDatabase

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 15:12
 * @Purpose :
 */
open class BaseActivity : AppCompatActivity() {
     lateinit var mContext: Context

     lateinit var mAppDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mAppDatabase = (application as AppApplication).mAppDatabase

    }
}