package com.yfl.livedata.job

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.job
 * @Email : yufeilong92@163.com
 * @Time :2021/1/1 21:42
 * @Purpose :
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
 public class JobStartServer : JobService (){
    companion object{
        fun startJob(mContext: Context){
            val jobScheduler = mContext.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

            val mBuild = ComponentName(mContext.packageName, JobStartServer::class.java.name)

            val jobInfom = JobInfo.Builder(1000, mBuild).setMinimumLatency(1000)
            val build = jobInfom.build()
            jobScheduler.schedule(build)
        }
    }


    override fun onStartJob(params: JobParameters?): Boolean {
        Log.e("startjon","===")
        startJob(this)
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        TODO("Not yet implemented")
    }
}