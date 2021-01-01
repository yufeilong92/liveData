package com.yfl.livedata.retrofit

import cn.ruiye.xiaole.retrofit.GsonFactory.GsonRequestBodyConverter
import cn.ruiye.xiaole.retrofit.GsonFactory.GsonResponseBodyConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type


class GsonDConverterFactory(val gson: Gson) : Converter.Factory() {


    fun create(): GsonDConverterFactory {
        return create(Gson())
    }

    fun create(gson: Gson): GsonDConverterFactory {
        return GsonDConverterFactory(gson)
    }


    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return GsonRequestBodyConverter(gson, adapter)
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return GsonResponseBodyConverter<BaseEntity<*>>(
            gson,
            type!!
        )
    }

}