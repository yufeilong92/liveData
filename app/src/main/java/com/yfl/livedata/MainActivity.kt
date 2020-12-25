package com.yfl.livedata

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.yfl.livedata.tRoom.Infom
import com.yfl.livedata.tRoom.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //添加
        btn_add.setOnClickListener {
            ++index
            val infom = Infom("小米$index", index)
            val user = User(0, "1", "1", infom)
            mAppDatabase.userDao().inserUser(user)
            mOneMinShow()
        }
        btn_query_id.setOnClickListener {
            val names = mAppDatabase.userDao().loadAllUserByAge(1)
            bindViewData(names)
        }


    }

    private fun mOneMinShow() {
        Handler().postDelayed({
            val loadAllUsers = mAppDatabase.userDao().loadAllUsers()

            bindViewData(loadAllUsers)

        }, 1000)

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