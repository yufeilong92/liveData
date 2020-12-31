package com.yfl.livedata

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.binioter.guideview.Component

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata
 * @Email : yufeilong92@163.com
 * @Time :2020/12/30 9:41
 * @Purpose :
 */
class SimpleComponent : Component {
    override fun getView(inflater: LayoutInflater?): View {
        val view = inflater?.inflate(R.layout.item_main_guile, null)
        view?.setOnClickListener {
            Toast.makeText(view.context, "底层被点击", Toast.LENGTH_SHORT).show();
        }
        return view!!

    }

    override fun getAnchor(): Int {
        return Component.ANCHOR_BOTTOM
    }

    override fun getFitPosition(): Int {
        return Component.FIT_END
    }

    override fun getXOffset(): Int {
        return 0
    }

    override fun getYOffset(): Int {
        return 10
    }
}