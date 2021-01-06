package com.yfl.livedata.refrect

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.refrect
 * @Email : yufeilong92@163.com
 * @Time :2021/1/5 14:37
 * @Purpose :代理公司
 */
open class MarkCompany : InvocationHandler {
    private var mFactory: Any? = null
    fun setFactory(obj: Any) {
        this.mFactory = obj
    }

    fun getInstance(): Any? {
        return Proxy.newProxyInstance(mFactory!!.javaClass.classLoader, mFactory!!.javaClass.interfaces, this,)
    }

    @Throws(Throwable::class)
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        val result = method?.invoke(mFactory, args)
        return result!!
    }

}