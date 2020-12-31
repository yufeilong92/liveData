package com.yfl.livedata.construction

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.construction
 * @Email : yufeilong92@163.com
 * @Time :2020/12/29 17:43
 * @Purpose :
 */
class StartA:InterfaceA {
    override fun startIntent() {
      println("StartA ->startIntent")
    }

    override fun startIntent(name: String) {
        println("StartA ->startIntent$name")
    }
}