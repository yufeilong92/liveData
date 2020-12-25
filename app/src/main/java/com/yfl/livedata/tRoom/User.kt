package com.yfl.livedata.tRoom

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.tRoom
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 14:41
 * @Purpose :
 */
@Entity(tableName = "infom")
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @Embedded
    val infom: Infom
) {
    override fun toString(): String {
        return "User(id=$id, firstName='$firstName', lastName='$lastName', infom=$infom)"
    }
}

