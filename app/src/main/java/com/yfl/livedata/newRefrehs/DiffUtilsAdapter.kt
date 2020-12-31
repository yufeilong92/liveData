package com.yfl.livedata.newRefrehs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.yfl.livedata.R

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.newRefrehs
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 14:37
 * @Purpose :
 */
class DiffUtilsAdapter(mContext: Context) :
    RecyclerView.Adapter<DiffUtilsAdapter.ViewHolder>() {

    private var mAsyclistDIffer: AsyncListDiffer<User>? = null

    init {
        mAsyclistDIffer = AsyncListDiffer<User>(this, DiffUtilAnsy())
    }

    private var mInflater: LayoutInflater = LayoutInflater.from(mContext)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv = view.findViewById<TextView>(R.id.tv_diffutil_content)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiffUtilsAdapter.ViewHolder {
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

    override fun onBindViewHolder(holder: DiffUtilsAdapter.ViewHolder, position: Int) {
        val user =getUserBean(position)
        holder.tv.text = user.name
        Log.i("刷新日志", "index=$position")
    }

    private fun getUserBean(position: Int):User{
         return mAsyclistDIffer?.currentList!![position]
    }
    override fun getItemCount(): Int {
        return mAsyclistDIffer?.currentList!!.size
    }

    fun setDatas(newList: MutableList<User>) {
        mAsyclistDIffer?.submitList(newList)
    }

}