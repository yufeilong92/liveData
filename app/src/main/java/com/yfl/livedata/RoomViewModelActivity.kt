package com.yfl.livedata

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yfl.livedata.tRoom.Infom
import com.yfl.livedata.tRoom.User
import com.yfl.livedata.viewModel.RoomViewModel
import kotlinx.android.synthetic.main.activity_main.btn_add
import kotlinx.android.synthetic.main.activity_main.btn_delete_all
import kotlinx.android.synthetic.main.activity_main.btn_delete_all_rx
import kotlinx.android.synthetic.main.activity_main.btn_query_id
import kotlinx.android.synthetic.main.activity_main.btn_query_id_rx
import kotlinx.android.synthetic.main.activity_main.btn_query_update
import kotlinx.android.synthetic.main.activity_main.tv_show_database
import kotlinx.android.synthetic.main.activity_room_view_model.*


class RoomViewModelActivity : BaseActivity() {
    var index = 0
    private lateinit var mRoomViewModel: RoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!::mRoomViewModel.isInitialized)
            mRoomViewModel = ViewModelProvider(this)[RoomViewModel::class.java]
        setContentView(R.layout.activity_room_view_model)
        initEvent()
        initListener()
        initViewModel()
    }

    private fun initEvent() {

    }

    private fun initListener() {
        //添加
        btn_add.setOnClickListener {
            ++index
            val infom = Infom("小米$index", index)
            val user = User(0, "1", "1", infom)
            mAppDatabase.userDao().inserUser(user)
        }
        btn_query_id.setOnClickListener {
            mRoomViewModel.loadAllUser(mAppDatabase)
        }

        btn_query_update.setOnClickListener {


        }

        btn_delete_all.setOnClickListener {
            tv_show_database.text = null
        }

        btn_query_id_rx.setOnClickListener {

        }


        btn_delete_all_rx.setOnClickListener {
            mAppDatabase.userDao().deleteAll()
        }
        btn_start_load_view.setOnClickListener {
            startActivity(Intent(this, LoadViewModelActivity::class.java))
        }
    }

    private fun initViewModel() {
        mRoomViewModel.getLoadUsers.observe(this, Observer {
            bindViewData(it)
        })
    }

    private fun bindViewData(loadAllUsers: MutableList<User>) {
        if (loadAllUsers.isNullOrEmpty()) {
            Toast.makeText(this, "数据为空", Toast.LENGTH_SHORT).show();
            return
        }
        val stringBuffer = StringBuffer()
        loadAllUsers.forEach {
            stringBuffer.append(it.toString())
            stringBuffer.append("\n")
            stringBuffer.append("\n")
        }
        tv_show_database.text = stringBuffer.toString()
    }
}