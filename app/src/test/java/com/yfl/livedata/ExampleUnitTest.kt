package com.yfl.livedata

import com.yfl.livedata.construction.StartFactory
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun text() {
        val mStartFactory = StartFactory.getInstance()
        mStartFactory?.startDoIntent(StartFactory.KEY_START_A)?.startIntent()
        mStartFactory?.startDoIntent(StartFactory.KEY_START_B)?.startIntent("测绘师B")
    }
}