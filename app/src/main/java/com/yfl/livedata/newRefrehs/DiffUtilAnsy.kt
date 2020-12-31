package com.yfl.livedata.newRefrehs

import androidx.recyclerview.widget.DiffUtil

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.newRefrehs
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 14:33
 * @Purpose :
 */
class DiffUtilAnsy : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        if (oldItem.id != newItem.id)
            return false
        if (oldItem.name != newItem.name)
            return false
        return true
    }

}