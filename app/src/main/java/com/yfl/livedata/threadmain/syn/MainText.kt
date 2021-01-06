package com.yfl.livedata.threadmain.syn

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.threadmain.syn
 * @Email : yufeilong92@163.com
 * @Time :2021/1/6 17:37
 * @Purpose :
 */
public class MainText {

    private val obj: Object = Object()
    private var cout = 0
    fun one(number: String) {
        synchronized(obj) {
            cout++
            println("线程$number==对象锁===$cout")
        }
        println("线程$number==对象锁执行完毕")
    }

}