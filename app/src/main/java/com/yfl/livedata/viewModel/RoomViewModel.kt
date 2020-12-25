package com.yfl.livedata.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yfl.livedata.tRoom.AndroidScheduler
import com.yfl.livedata.tRoom.AppDatabase
import com.yfl.livedata.tRoom.User
import io.reactivex.schedulers.Schedulers

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.viewModel
 * @Email : yufeilong92@163.com
 * @Time :2020/12/25 17:42
 * @Purpose :
 */
class RoomViewModel : ViewModel() {
    val getLoadUsers: MutableLiveData<MutableList<User>> by lazy {
        MutableLiveData<MutableList<User>>()
    }

    fun loadAllUser(mAppDatabase: AppDatabase) {
        mAppDatabase.userDao()
            .loadAllRxJava()
            .observeOn(Schedulers.io())
            .observeOn(AndroidScheduler().mainThread())
            .subscribe {
                getLoadUsers.value = it
            }

    }

}