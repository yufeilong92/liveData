package com.yfl.livedata.newRefrehs

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.yfl.livedata.R
import com.yfl.livedata.net.NetActivity
import kotlinx.android.synthetic.main.activity_diff_utils.*

/**
 * @Author : YFL  is Creating a porject in Dell
 * @Package : com.yfl.livedata.newRefrehs
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 11:26
 * @Purpose :diffutil
 */
class DiffUtilsActivity : AppCompatActivity() {

    var list: MutableList<User>? = null
    var adpter: DiffUtilsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_utils)
        val gl = GridLayoutManager(this, 1)
        list = getData()
        rlv_diffutil_content.layoutManager = gl
        adpter = DiffUtilsAdapter(this)
        adpter?.setDatas(list!!)
        rlv_diffutil_content.adapter = adpter
        tv_diffutil_title.setOnClickListener {
            refresh()
        }
        tv_diffutite_add_more.setOnClickListener {
            addMore()
        }
        btn_start_net.setOnClickListener {
            startActivity(Intent(this, NetActivity::class.java))
        }
    }

    private fun refresh() {
        val newList = mutableListOf<User>()
        if (list.isNullOrEmpty()) {
            list = mutableListOf()
        } else {
            list?.let {
                it.forEachIndexed { index, user ->
                    if (index % 2 == 0) {
                        newList.add(User(index, "修改名字$index"))
                    } else
                        newList.add(user)

                }
            }
        }
//        val mDiffUtil = DiffUtil.calculateDiff(DiffUtils(list, newList))
        list = newList
        adpter?.setDatas(newList)
//        adpter?.notifyDataSetChanged()
//        mDiffUtil.dispatchUpdatesTo(adpter!!)
    }

    private fun addMore() {
        val newList = mutableListOf<User>()
        for (index in list!!.size..list!!.size + 10) {
            newList.add(User(index, "名字$index"))
        }
        list?.addAll(newList)
        adpter?.notifyDataSetChanged()
    }

    private fun getData(): MutableList<User> {
        val list = mutableListOf<User>()
        for (index in 0..23) {
            list.add(User(index, "名字$index"))
        }
        return list
    }


    fun <T : View> getViewById(view: View, id: Int): T {
        return view.findViewById<T>(id)
    }


}