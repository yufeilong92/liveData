package cn.ruiye.xiaole.retrofit.GsonFactory

//import com.igexin.sdk.PushManager
import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.yfl.livedata.retrofit.ResultException
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter
import java.lang.reflect.Type


class GsonResponseBodyConverter<T>(val gson:Gson, val type:Type): Converter<ResponseBody,T>{

    override fun convert(value: ResponseBody?): T {
        val response = value!!.string()
        Log.d("response==",response.toString())
        value.use { value ->
            // 这里的type实际类型是 LoginUserEntity<User>  User就是user字段的对象。
            if (!response.startsWith("{") || !response.endsWith("}")) {
                throw ResultException("服务器有误，请联系客服", "-10", "")
            }
            val jsonResult: JSONObject = JSONObject(response)
                    ?: throw ResultException(
                        "服务器有误，请联系客服",
                        "-10",
                        ""
                    )
            val status = jsonResult.optString("code")
            if (TextUtils.isEmpty(status)) {
                throw ResultException(
                    "其他问题",
                    "-1038",
                    response
                )
            } else {
                val code = jsonResult.optString("code")
                when(code){
               "100001","100002","0" -> {
                        return gson.fromJson(response, type)
                    }
                    else -> {
                        throw ResultException(
                            jsonResult.optString("msg"), code, jsonResult.optString("data")
                                ?: ""
                        )
                    }
                }
            }
        }
    }
}