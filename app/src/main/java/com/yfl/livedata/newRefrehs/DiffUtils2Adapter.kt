package com.yfl.livedata.newRefrehs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yfl.livedata.R

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.newRefrehs
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 14:37
 * @Purpose :
 */
class DiffUtils2Adapter (mContext:Context, var data: MutableList<User>?) :
    RecyclerView.Adapter<DiffUtils2Adapter.ViewHolder>() {
    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv = view.findViewById<TextView>(R.id.tv_diffutil_content)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):DiffUtils2Adapter.ViewHolder {
        return ViewHolder(mInflater.inflate(R.layout.item_diffutl, null))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (!payloads.isNullOrEmpty()) {
            payloads.forEach {
                val bundle = it as Bundle
                holder.tv.text = bundle.getString("name")
            }
        } else
            super.onBindViewHolder(holder, position, payloads)
    }

    override fun onBindViewHolder(holder:DiffUtils2Adapter.ViewHolder, position: Int) {
        val user = data!![position]
        holder.tv.text = user.name
        Log.i("刷新日志", "index=$position")
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    fun setDatas(newList: MutableList<User>) {
        this.data = newList
    }

}