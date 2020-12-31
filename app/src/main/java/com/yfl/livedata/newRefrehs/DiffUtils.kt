package com.yfl.livedata.newRefrehs

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 11:07
 * @Purpose :
 */
class DiffUtils(var old: MutableList<User>?, var new: MutableList<User>?) : DiffUtil.Callback() {
    private var oldLists: MutableList<User>? = null
    private var newLists: MutableList<User>? = null

    init {
        this.newLists = new
        this.oldLists = old
    }


    override fun getOldListSize(): Int {
        return if (oldLists == null) 0 else oldLists!!.size
    }

    override fun getNewListSize(): Int {
        return if (newLists == null) 0 else newLists!!.size
    }

    //判断是否是同一个item
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        var new:User? = null
        var old:User ?= null
        oldLists?.let {
            old = it.get(oldItemPosition)
        }
        newLists?.let {
            new = it.get(newItemPosition)
        }
        return new?.id == old?.id
    }
    //同一个item，所有主要值是否相同，不相同false   刷新
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        var new:User? = null
        var old:User ?= null
        oldLists?.let {
            old = it.get(oldItemPosition)
        }
        newLists?.let {
            new = it.get(newItemPosition)
        }
       if (new?.id!=old?.id)
           return false
        if (new?.name!=old?.name){
            return false
        }
        return true
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {

        var new:User? = null
        var old:User ?= null
        oldLists?.let {
            old = it.get(oldItemPosition)
        }
        newLists?.let {
            new = it.get(newItemPosition)
        }
        val bundle=Bundle()
        if (new?.id!=old?.id)
            bundle.putInt("id",new!!.id)
        if (new?.name!=old?.name){
            bundle.putString("name",new?.name)
        }
        return bundle
    }
}