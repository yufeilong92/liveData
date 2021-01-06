package com.yfl.livedata.threadmain

import java.util.concurrent.Callable

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.threadmain
 * @Email : yufeilong92@163.com
 * @Time :2021/1/6 11:44
 * @Purpose :
 */
class CallAbleOne : Callable<String> {
    override fun call(): String {
        println("执行callable")
        return "callable_string"
    }
}