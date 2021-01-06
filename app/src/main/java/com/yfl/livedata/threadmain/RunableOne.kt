package com.yfl.livedata.threadmain

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.threadmain
 * @Email : yufeilong92@163.com
 * @Time :2021/1/6 11:43
 * @Purpose :
 */
class RunableOne : Runnable {
    override fun run() {
        println("${Thread.currentThread().name} ===runnabke_run")
    }
}