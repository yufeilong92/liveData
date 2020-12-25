package com.yfl.livedata.tRoom

import android.os.Handler
import android.os.Looper
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor


/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.tRoom
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 16:37
 * @Purpose :
 */
public class AndroidScheduler : Executor {

    private var instance: AndroidScheduler? = null

    private var mMainScheduler: Scheduler? = null
    private var mHandler: Handler? = null

    constructor() {
        mHandler = Looper.myLooper()?.let { Handler(it) }
        mMainScheduler = Schedulers.from(this)
    }

    @Synchronized
     fun mainThread(): Scheduler? {
        if (instance == null) {
            instance = AndroidScheduler()
        }
        return instance?.mMainScheduler
    }



    override fun execute(command: Runnable?) {
        mHandler?.post(command!!);
    }


}