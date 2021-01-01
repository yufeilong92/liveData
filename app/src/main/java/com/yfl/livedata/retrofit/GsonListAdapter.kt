package com.yfl.livedata.retrofit

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.retrofit
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 20:10
 * @Purpose :
 */
class GsonListAdapter : JsonDeserializer<List<*>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<*> {
        if (json == null || !json.isJsonArray) {
            return Collections.EMPTY_LIST
        } else {

            return Gson().fromJson(json, typeOfT)
        }
    }
}