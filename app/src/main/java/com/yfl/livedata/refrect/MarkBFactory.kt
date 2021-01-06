package com.yfl.livedata.refrect

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.refrect
 * @Email : yufeilong92@163.com
 * @Time :2021/1/5 16:08
 * @Purpose :
 */
class MarkBFactory:MarkFactory {
    override fun mark(number: Int) {
        println("我要打劫${number}银行")
    }
}