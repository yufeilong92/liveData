package com.yfl.livedata.tRoom

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

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

    @Query("delete from infom")
    fun deleteAll()

    @Query("select * from infom")
    fun loadAllUsers(): MutableList<User>


    @Query("select * from infom where firstName= :firstname")
    fun loadAllUserByFirstName(firstname: String): MutableList<User>

    @Query("select * from infom where age= :age")
    fun loadAllUserByAge(age: Int): MutableList<User>

    //rxjava 写法

    @Query("SELECT * FROM INFOM")
    fun loadAllRxJava(): Flowable<MutableList<User>>

    @Query("delete from infom")
    fun deleteALLRxJava()

    @Update(entity = User::class)
    fun updateByAge(user: User):Completable

}