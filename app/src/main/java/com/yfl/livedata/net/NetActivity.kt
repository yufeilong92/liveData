package com.yfl.livedata.net

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yfl.livedata.R
import com.yfl.livedata.retrofit.RetrofitFactory
import com.yfl.livedata.tRoom.AndroidScheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_net.*

/**
 * @Author : YFL  is Creating a porject in Dell
 * @Package : com.yfl.livedata.net
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 19:22
 * @Purpose :网络
 */
class NetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net)
        initEvent()
        initListener()
        initViewModel()
    }

    private fun initEvent() {

    }

    private fun initListener() {
        btn_request_baidu.setOnClickListener {
            RetrofitFactory.createMainRetrofit().requetsBaiDu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidScheduler().mainThread())
                .subscribe(
                    {},
                    {},
                    {})

        }
    }

    private fun initViewModel() {

    }

}