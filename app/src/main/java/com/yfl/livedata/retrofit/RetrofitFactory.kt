package com.yfl.livedata.retrofit

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yfl.livedata.net.BaseDNS
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by apple on 2018/7/8.
 */
object RetrofitFactory {


    //    val BASE_URL: String = "http://zzzh.natapp1.cc/"
    val BASE_URL: String = "https://www.baidu.com"

    private val TIMEOUT: Long = 60000
    private var mainRetrofit: Main_Interface? = null
    private var mineRetrofit: Main_Interface? = null
    val interceptor = CommonInterceptor()
    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .dns(BaseDNS())
        .build()

    private fun buildGson(): Gson {
        val gsonBuilder = GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(List::class.java, GsonListAdapter::class.java)
            .registerTypeAdapter(Int::class.java, GsonIntegerAdapter::class.java)
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()

        return gsonBuilder
    }

    private fun createRetrofit(): Retrofit {
        val map = HashMap<String, String>()
        CommonInterceptor.setCommonParam(map)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(
                GsonDConverterFactory(
                    buildGson()
                )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun createMainRetrofit(): Main_Interface {
        if (mainRetrofit == null) {
            mainRetrofit = createRetrofit().create(Main_Interface::class.java)
        }
        return mainRetrofit!!
    }

    fun createMineRetrofit(): Main_Interface {
        if (mineRetrofit == null) {
            mineRetrofit = createRetrofit().create(Main_Interface::class.java)
        }
        return mineRetrofit!!
    }


}