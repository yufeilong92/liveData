package com.yfl.livedata.threadmain

import com.yfl.livedata.threadmain.syn.MainText

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.threadmain
 * @Email : yufeilong92@163.com
 * @Time :2021/1/6 11:41
 * @Purpose :
 */
class UserThread : Thread() {
    override fun run() {
        val main = MainText()
        main.one(Thread.currentThread().name)
    }

}