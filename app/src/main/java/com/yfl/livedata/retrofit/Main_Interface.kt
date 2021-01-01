package com.yfl.livedata.retrofit

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.retrofit
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 19:39
 * @Purpose :
 */
interface Main_Interface {
    @GET("/")
    fun requetsBaiDu(): Observable<BaseEntity<Any>>
}