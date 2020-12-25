package com.yfl.livedata.tRoom

import androidx.room.*

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.tRoom
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 14:48
 * @Purpose :
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserUser(vararg user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun upDateUsers(vararg user: User)

    @Delete
    fun deleteUsers(vararg user: User)

    @Query("select * from infom")
    fun loadAllUsers(): MutableList<User>


    @Query("select * from infom where firstName= :firstname")
    fun loadAllUserByFirstName(firstname: String): MutableList<User>

    @Query("select * from infom where age= :age")
    fun loadAllUserByAge(age: Int): MutableList<User>

}