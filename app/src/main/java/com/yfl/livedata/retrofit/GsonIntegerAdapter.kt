package com.yfl.livedata.retrofit

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.retrofit
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 20:10
 * @Purpose :
 */
class GsonIntegerAdapter : JsonDeserializer<Int> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Int {
        if (json == null) {
            return 0
        } else {
            try {
                return json.asInt
            } catch (e: Exception) {
                return 0
            }
        }

    }

}