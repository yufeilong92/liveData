package com.yfl.livedata.tRoom

import androidx.room.TypeConverter
import java.util.*

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.tRoom
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 15:07
 * @Purpose :
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dataToTimestamp(data: Date?): Long? {
        return if (data == null) null else data.time
    }

}