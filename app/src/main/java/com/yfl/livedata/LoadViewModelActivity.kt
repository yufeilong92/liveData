package com.yfl.livedata

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yfl.livedata.viewModel.RoomViewModel
import kotlinx.android.synthetic.main.activity_load_view_model.*

class LoadViewModelActivity : BaseActivity() {

    private val mViewModel: RoomViewModel by lazy {
        ViewModelProvider(this).get(RoomViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_view_model)
        mViewModel.loadAllUser(mAppDatabase)
        initEvent()
        initListener()
        initViewModel()
        tv_load_view_content.setOnClickListener {
            initPopuWindow()
        }
    }

    private fun initPopuWindow() {

        val view = LayoutInflater.from(this).inflate(R.layout.pop_item, null)
        val popWinds = PopupWindow(
            view,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,true
        )
        popWinds.isTouchable = true
        popWinds.setTouchInterceptor { v, event -> false }
        popWinds.setBackgroundDrawable(ColorDrawable(0x00000000))
        val w = tv_load_view_content.width
        popWinds.showAsDropDown(tv_load_view_content, w/3,tv_load_view_content.height)

    }

    private fun initEvent() {

    }

    private fun initListener() {

    }

    private fun initViewModel() {
        mViewModel.getLoadUsers.observe(this, Observer {
            tv_load_view_content.text = "${it.toString()}"
        })

    }
}