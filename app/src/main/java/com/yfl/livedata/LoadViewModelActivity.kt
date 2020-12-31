package com.yfl.livedata

import android.content.ContentValues
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.binioter.guideview.GuideBuilder
import com.yfl.livedata.db.MySqliteHelp
import com.yfl.livedata.newRefrehs.DiffUtilsActivity
import com.yfl.livedata.viewModel.RoomViewModel
import kotlinx.android.synthetic.main.activity_load_view_model.*
import java.util.*
import kotlin.collections.HashMap

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
        val instance = MySqliteHelp.getInstance(this, "sql.db", 1)
        val writableDatabase = instance?.writableDatabase

        tv_load_view_content.setOnClickListener {
            initPopuWindow()
        }
        btn_load_add_sql.setOnClickListener {
            writableDatabase?.let {
                it.beginTransaction()
                val valueContent = ContentValues()
                valueContent.put("name", "小米")
                valueContent.put("age", 1)
                valueContent.put("class", "一班级")
                it.insert("user", null, valueContent)
                it.setTransactionSuccessful()
                it.endTransaction()
            }

        }
        btn_load_add_show.setOnClickListener {
            writableDatabase?.let {
                val couster = it.query("user", null, null, null, null, null, null)
                val str = StringBuffer()
                while (couster.moveToNext()) {
                    val age = couster.getInt(couster.getColumnIndex("age"))
                    val name = couster.getString(couster.getColumnIndex("name"))
                    val classs = couster.getString(couster.getColumnIndex("class"))
                    str.append("$age---$name---$classs \n\n")

                }
                couster.close()
                tv_load_view_content.text = str.toString()
            }
            HashMap<String, String>()

        }
        btn_load_add_delet.setOnClickListener {
            writableDatabase?.let {
                it.delete("user", null, null)
            }
        }
//        showGuideView()
        start_diffutil.setOnClickListener {
            startActivity(Intent(this, DiffUtilsActivity::class.java))
        }
    }

    private fun showGuideView() {
        val buidle = GuideBuilder()
            .setTargetView(btn_load_add_show)
            .setAlpha(150)
            .setHighTargetCorner(20)
            .setHighTargetPadding(10)

        buidle.setOnVisibilityChangedListener(object : GuideBuilder.OnVisibilityChangedListener {
            override fun onShown() {

            }

            override fun onDismiss() {
            }

        })
        buidle.addComponent(SimpleComponent())
        val createGuide = buidle.createGuide()
        createGuide.show(this)
    }

    private fun initPopuWindow() {

        val view = LayoutInflater.from(this).inflate(R.layout.pop_item, null)
        val popWinds = PopupWindow(
            view,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, true
        )
        popWinds.isTouchable = true
        popWinds.setTouchInterceptor { v, event -> false }
        popWinds.setBackgroundDrawable(ColorDrawable(0x00000000))
        val w = tv_load_view_content.width
        popWinds.showAsDropDown(tv_load_view_content, w / 3, tv_load_view_content.height)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                TODO("Not yet implemented")
            }
        }, 1000)
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