package com.yfl.livedata.construction

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.construction
 * @Email : yufeilong92@163.com
 * @Time :2020/12/29 17:43
 * @Purpose :
 */
class StartFactory {

    companion object {//被companion object包裹的语句都是private的

        val KEY_START_A = "a"
        val KEY_START_B = "b"
        private var singletonInstance: StartFactory? = null

        @Synchronized
        fun getInstance(): StartFactory? {
            if (singletonInstance == null) {
                singletonInstance = StartFactory()
            }
            return singletonInstance
        }
    }
    private final val mStartMap = hashMapOf<String, InterfaceA>()

    init {
        mStartMap.put(KEY_START_A, StartA())
        mStartMap.put(KEY_START_B, StartB())
    }

    fun startDoIntent(key: String): InterfaceA? {
        return mStartMap.get(key)
    }

}